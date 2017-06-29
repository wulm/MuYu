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

	/**
	 * ɾ������
	 * @return
	 */
	public String deleteArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleService.deleteArticle(articleId);
		articleList = articleService.getByType(articleType);

		return "articleEditList";
	}

	/**
	 * �༭���£����⣬���Ե����ݣ�
	 * @return
	 */
	public String gotoArticleEditList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleList = articleService.getByType(articleType);
		return "articleEditList";
	}

	/**
	 * �û���ת�������б�
	 * @return
	 */
	public String gotoArticleUserList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		articleList = articleService.getByType(articleType);
		return "articleUserList";
	}

	/**
	 * �û���ת�����¾�������ҳ��
	 */
	public String gotoArticleUserContent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		MyArticleContent article = articleService
				.getArticleContentByArticleId(articleId);
		request.getSession().setAttribute("article", article);
		return "articleUserContent";
	}

	
	
	/***
	 * ����Ա��ת���������ҳ��
	 * @return
	 */
	public String gotoAddArticle() {
		article=new MyArticle();//��ջ���
		articleContent=new MyArticleContent();//��ջ���
		return "articleAddOrEdit";
	}

	
	/***
	 * ����Ա��ת���༭����ҳ��
	 * @return
	 */
	public String gotoEditArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		article = articleService.getArticleByArticleId(articleId);
		return "articleAddOrEdit";
	}

	
	/**
	 * �������ͻ�ȡ�����б�
	 * @return
	 */
	public String getArticleByType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType = Integer.parseInt(request.getParameter("articleType"));
		List<MyArticle> articles = articleService.getByType(articleType);
		return "articleList";
	}

	/**
	 * �������²���ת����������ҳ
	 * @return
	 */
	public String DoSaveArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameter("articleId"));
		int articleId = Integer
				.parseInt(request.getParameter("articleId") .isEmpty() ? "-100"
						: request.getParameter("articleId"));
		int articleType = Integer.parseInt(request.getParameter("articleType"));
		String articleTitle = request.getParameter("articleTitle");
		//String articleTitleImageUrl = request.getParameter("articleTitleImageUrl");
		String writerName = request.getParameter("writerName");
		String articleLeadText = request.getParameter("articleLeadText");
		String articleTitleImageUrl = request.getParameter("articleTitleImageUrl");
		String createDate = request.getParameter("createDate").isEmpty()?"2017-01-01 00:00:00":request.getParameter("createDate");
		
		System.out.println(createDate);
		article= new MyArticle(articleId, writerName, articleType,
				articleTitle, articleTitleImageUrl, articleLeadText,
				Timestamp.valueOf(createDate), new Timestamp(
						System.currentTimeMillis()), 0);
		if (articleId == -100) {
			int articleId2=articleService.addArticle(article);
		} else {
			articleService.updateArticle(article);
			articleContent = articleService
					.getArticleContentByArticleId(articleId);
			articleContent.setMyArticle(article);
		}
		return "articleContentAddOrEdit";
	}

	
	
	/**
	 * ����������������
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String DoSaveArticleContent() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer
				.parseInt(request.getParameter("articleId") == null ? "-100"
						: request.getParameter("articleId"));
		
		String articleContentBuff = request.getParameter("articleContent");
		String articleContent=new String(articleContentBuff.getBytes("ISO-8859-1"), "UTF-8"); //���Ľ���
		
		MyArticleContent articleContent2= new MyArticleContent();
		articleContent2.setArticleContent(articleContent);
		MyArticle articleBuff=articleService.getArticleByArticleId(articleId);
		articleContent2.setMyArticle(articleBuff);
		
		if (articleId == -100) {
			System.out.println("ǰ̨�����˷Ƿ�����id������ΪDoSaveArticleContent");
		} else {
			articleService.updateArticleContent(articleContent2);
		}
		return "articleManage";
	}
	
	/**
	 * ѹ�����ϴ�����ͼƬ����
	 * @throws IOException
	 * @throws ServletException
	 */
	public void UploadImage() throws IOException, ServletException {
		
		HttpServletRequest request = ServletActionContext.getRequest();//����request����
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response = ServletActionContext.getResponse();//response���󷵻����ݸ�ǰ̨
		response.setContentType("application/json; charset=utf-8");
		String base64Img=request.getParameter("img").toString();
		base64Img=base64Img.replace("data:image/jpeg;base64,", "");//ȥ��base64�����õ��ļ�ͷ
		String realSavePath=request.getSession().getServletContext().getRealPath("/WeixinPages/uploadImg/articleImage/");//����ͼƬ�ľ���·��
		String imgName=ImageMethod.Base64SaveAsImage(base64Img, realSavePath);//����ͼƬ��ϵͳӦ���ļ�����
		
		
		Map<String, String> map = new HashMap<String, String>();
		String showPath=request.getContextPath() +"/WeixinPages/uploadImg/articleImage/";
		//System.out.println(showPath+imgName);
		if(imgName==null){
			map.put("done", "-1");
			map.put("imgSrc", showPath+"nofound.jpg");
			map.put("msg", "ͼƬ�ϴ�ʧ����!");
		}else{
			map.put("done", "0");
			map.put("imgSrc", showPath+imgName);//��ʾͼƬ���������·��
			map.put("msg", "ͼƬ�ϴ��ɹ�!");
			System.out.println("�û��ϴ�ͼƬ����"+showPath+imgName);
		}
		
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString()); 

	}

	
	/**
	 * ѹ�����ϴ�����ͼ��
	 * @throws IOException
	 * @throws ServletException
	 */
	public void UploadIcon() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();//����request����
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response = ServletActionContext.getResponse(); //response���󷵻����ݸ�ǰ̨
		response.setContentType("application/json; charset=utf-8");
		String base64Img=request.getParameter("img").toString();
		base64Img=base64Img.replace("data:image/jpeg;base64,", "");//ȥ��base64�����õ��ļ�ͷ
		String realSavePath=request.getSession().getServletContext().getRealPath("/WeixinPages/uploadImg/articleIcon/");//����ͼƬ�ľ���·��
		String imgName=ImageMethod.Base64SaveAsImage(base64Img, realSavePath);//����ͼƬ��ϵͳӦ���ļ�����
		
		
		Map<String, String> map = new HashMap<String, String>();
		String showPath=request.getContextPath() +"/WeixinPages/uploadImg/articleIcon/";
		//System.out.println(showPath+imgName);
		if(imgName==null){
			map.put("done", "-1");
			map.put("imgSrc", showPath+"nofound.jpg");
			map.put("msg", "ͼ���ϴ�ʧ����!");
		}else{
			map.put("done", "0");
			map.put("imgSrc", showPath+imgName);//��ʾͼƬ���������·��
			map.put("msg", "ͼ���ϴ��ɹ�!");
			System.out.println("�û��ϴ�ͼ������"+showPath+imgName);
		}
		
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().write(jsonObject.toString()); 
		
	}
	
	
	
	
}
