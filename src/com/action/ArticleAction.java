package com.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import com.bean.MyArticle;
import com.bean.MyArticleContent;
import com.service.IArticleService;
import com.util.ImageMethod;

public class ArticleAction {

	private IArticleService articleService;// ������ҵ��

	private List<MyArticle> articleList;// �����б�

	private MyArticle article;// ��������

	private MyArticleContent articleContent;// �������¾�������

	private int articleType;// �������

//	private File imageUpload;// ͼƬ�ϴ�buffer
//
//	private String imageUploadFileName;// ͼƬ�ļ���
//	
//	private String imageUploadContentType;;// �ϴ��ļ�����
//
//	public String getImageUploadContentType() {
//		return imageUploadContentType;
//	}
//
//	public void setImageUploadContentType(String imageUploadContentType) {
//		this.imageUploadContentType = imageUploadContentType;
//	}
//
//	public String getImageUploadFileName() {
//		return imageUploadFileName;
//	}
//
//	public void setImageUploadFileName(String imageUploadFileName) {
//		this.imageUploadFileName = imageUploadFileName;
//	}
//
//	public File getImageUpload() {
//		return imageUpload;
//	}
//
//	public void setImageUpload(File imageUpload) {
//		this.imageUpload = imageUpload;
//	}

	public int getArticleType() {
		return articleType;
	}

	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}

	public List<MyArticle> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<MyArticle> articleList) {
		this.articleList = articleList;
	}

	public MyArticle getArticle() {
		return article;
	}

	public void setArticle(MyArticle article) {
		this.article = article;
	}

	public MyArticleContent getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(MyArticleContent articleContent) {
		this.articleContent = articleContent;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public String deleteArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleService.deleteArticle(articleId);
		articleList = articleService.getByType(articleType);

		return "articleEditList";
	}

	public String gotoArticleEditList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleList = articleService.getByType(articleType);
		return "articleEditList";
	}

	public String gotoArticleUserList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleList = articleService.getByType(articleType);
		return "articleUserList";
	}

	public String gotoArticleUserContent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		MyArticleContent article = articleService
				.getArticleContentByArticleId(articleId);
		request.getSession().setAttribute("article", article);
		return "articleUserContent";
	}

	public String gotoAddArticle() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String id = request.getParameter("articleId");
//		if (null != id) {
//			int articleId = Integer.parseInt(id);
//			article = articleService.getArticleByArticleId(articleId);
//		}
		article=new MyArticle();//��ջ���
		articleContent=new MyArticleContent();//��ջ���
		return "articleAddOrEdit";
	}

	public String gotoEditArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		article = articleService.getArticleByArticleId(articleId);
		return "articleAddOrEdit";
	}

	public String getArticleByType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		List<MyArticle> articles = articleService.getByType(articleType);
		return "articleList";
	}

	
	public String DoSaveArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameter("articleId"));
		int articleId = Integer
				.parseInt(request.getParameter("articleId") .isEmpty() ? "-100"
						: request.getParameter("articleId"));
		int articleType = Integer.parseInt(request.getParameter("articleType"));
		String articleTitle = request.getParameter("articleTitle");
		String writerName = request.getParameter("writerName");
		String articleLeadText = request.getParameter("articleLeadText");
		String articleTitleImageUrl = request
				.getParameter("articleTitleImageUrl");
		String createDate = request.getParameter("createDate").isEmpty()?"2017-01-01 00:00:00":request.getParameter("createDate");
		
		System.out.println(createDate);
		article= new MyArticle(articleId, writerName, articleType,
				articleTitle, articleTitleImageUrl, articleLeadText,
				Timestamp.valueOf(createDate), new Timestamp(
						System.currentTimeMillis()), 0);
		if (articleId == -100) {
			int articleId2=articleService.addArticle(article);
			//article.setArticleId(articleId2);
			
		} else {
			articleService.updateArticle(article);
			articleContent = articleService
					.getArticleContentByArticleId(articleId);
		}
		return "articleContentAddOrEdit";
	}

	public String DoSaveArticleContent() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer
				.parseInt(request.getParameter("articleId") == null ? "-100"
						: request.getParameter("articleId"));
		
		String articleContentBuff = request.getParameter("articleContent");
		String articleContent=new String(articleContentBuff.getBytes("ISO-8859-1"), "UTF-8"); 
		
		
		System.out.println(articleContent);
	/*	(Integer articleContentId, MyArticle myArticle,
				String articleContent, String writerName, String articleTitle,
				Integer praiseClickNum, Timestamp createDate, Timestamp updateDate,
				Integer state)*/
				
				
		MyArticleContent articleContent2= new MyArticleContent();
		articleContent2.setArticleContent(articleContent);
		MyArticle articleBuff=articleService.getArticleByArticleId(articleId);
		articleContent2.setMyArticle(articleBuff);
		
		if (articleId == -100) {
			//articleService.addArticleContent(articleContentBuff);
		} else {
			articleService.updateArticleContent(articleContent2);
			//articleContent = articleService
			//		.getArticleContentByArticleId(articleId);
		}
		return "articleManage";
	}
	
	
	public void UploadImage() throws IOException, ServletException {
		
		HttpServletRequest request = ServletActionContext.getRequest();//����request����
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response = ServletActionContext.getResponse();//response���󷵻����ݸ�ǰ̨
		response.setContentType("application/json; charset=utf-8");
		String base64Img=request.getParameter("img").toString();
		base64Img.replace("data:image/jpeg;base64,", "");//ȥ��base64�����õ��ļ�ͷ
		String realSavePath=request.getSession().getServletContext().getRealPath("/WeixinPages/uploadImg/");//����ͼƬ�ľ���·��
		String imgName=ImageMethod.Base64SaveAsImage(base64Img, realSavePath);//����ͼƬ��ϵͳӦ���ļ�����
		
		
		Map<String, String> map = new HashMap<String, String>();
		String showPath="/uploadImg/";
		System.out.println(showPath+imgName);
		if(imgName==null){
			map.put("done", "-1");
			map.put("imgSrc", showPath+"nofound.jpg");
			map.put("msg", "ͼƬ�ϴ�ʧ����!");
		}else{
			map.put("done", "0");
			map.put("imgSrc", showPath+imgName);//��ʾͼƬ���������·��
			map.put("msg", "ͼƬ�ϴ��ɹ�!");
		}
		
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString()); 
		
		//System.out.println(base64Img);
		//System.out.println(imageUpload);

		/*HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//response.setContentType("textml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		FileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<?> items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) { // �������ͨ���ֶ�
					String name = item.getFieldName();
					String value = item.getString();
				} else {

					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					String imgPath = request.getSession().getServletContext()
							.getRealPath("/WeixinPages/uploadImg");// request.getRealPath("/")
					File uploadedFile = new File(imgPath + "/" + fileName);
					try {
						item.write(uploadedFile);

						System.out.println("ͼƬ����ɹ���·��" +request.getContextPath() + "/WeixinPages/uploadImg/"
								+ fileName);
						
						JSONObject s=new JSONObject();
						 s.put("imgUrl", request.getContextPath() + "/WeixinPages/uploadImg/"+ fileName);//��Ӷ��� 
						 s.put("message", "ͼƬ�ϴ��ɹ���");//��Ӷ��� 
						
						 
						// ����ͼƬ��URL��ַ
						response.getWriter().write(s.toString());
					} catch (Exception e) { // TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}*/

	}

		  
		/*HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType("textml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("textarea1");// myFileName���ļ����name����ֵ
		// �ļ���������
		String[] allowedType = { "image/bmp", "image/gif", "image/jpeg",
				"image/png" };
		boolean allowed = Arrays.asList(allowedType).contains(
				part.getContentType());
		if (!allowed) {
			response.getWriter().write("error|��֧�ֵ�����");
			return;
		}
		// ͼƬ��С����
		if (part.getSize() > 5 * 1024 * 1024) {
			response.getWriter().write("error|ͼƬ��С���ܳ���5M");
			return;
		}
		// ����ԭʼ�ļ������ַ���
		String fi = part.getHeader("content-disposition");
		// ��ȡ�ļ���չ��
		String fileNameExtension = fi.substring(fi.indexOf("."),
				fi.length() - 1);
		// ����ʵ�ʴ洢����ʵ�ļ���
		String realName = UUID.randomUUID().toString() + fileNameExtension;
		// ͼƬ��ŵ���ʵ·��
		String realPath = request.getSession().getServletContext()
				.getRealPath("/WeixinPages/uploadImg")
				+ "/" + realName;
		// ���ļ�д��ָ��·����
		part.write(realPath);

		System.out.println(request.getContextPath() + "/WeixinPages/uploadImg/"
				+ realName);
		
		// ����ͼƬ��URL��ַ
		response.getWriter()
				.write(request.getContextPath() + "/WeixinPages/uploadImg/"
						+ realName);
	}*/
	

}
