package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.multipart.MultipartFile;

import com.bean.MyArticle;
import com.bean.MyArticleContent;
import com.service.IArticleService;

public class ArticleAction {

	private IArticleService articleService;// 文章类业务

	private List<MyArticle> articleList;// 文章列表

	private MyArticle article;// 单个文章

	private MyArticleContent articleContent;// 单个文章具体内容

	private int articleType;// 文章类别

	private File imageUpload;// 图片上传buffer

	private String imageUploadFileName;// 图片文件名
	
	private String imageUploadContentType;;// 上传文件类型

	public String getImageUploadContentType() {
		return imageUploadContentType;
	}

	public void setImageUploadContentType(String imageUploadContentType) {
		this.imageUploadContentType = imageUploadContentType;
	}

	public String getImageUploadFileName() {
		return imageUploadFileName;
	}

	public void setImageUploadFileName(String imageUploadFileName) {
		this.imageUploadFileName = imageUploadFileName;
	}

	public File getImageUpload() {
		return imageUpload;
	}

	public void setImageUpload(File imageUpload) {
		this.imageUpload = imageUpload;
	}

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
		return "articleDetail";
	}

	public String gotoAddArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("articleId");
		if (null != id) {
			int articleId = Integer.parseInt(id);
			article = articleService.getArticleByArticleId(articleId);
		}
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

	public String DoAddArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();

		return "";
	}

	public String DoSaveArticle() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId = Integer
				.parseInt(request.getParameter("articleId") == null ? "-100"
						: request.getParameter("articleId"));
		int articleType = Integer.parseInt(request.getParameter("articleType"));
		String articleTitle = request.getParameter("articleTitle");
		String writerName = request.getParameter("writerName");
		String articleLeadText = request.getParameter("articleLeadText");
		String articleTitleImageUrl = request
				.getParameter("articleTitleImageUrl");
		String createDate = request.getParameter("createDate");
		MyArticle ma = new MyArticle(articleId, writerName, articleType,
				articleTitle, articleTitleImageUrl, articleLeadText,
				Timestamp.valueOf(createDate), new Timestamp(
						System.currentTimeMillis()), 0);
		if (articleId == -100) {
			articleService.addArticle(ma);
		} else {
			articleService.updateArticle(ma);
			articleContent = articleService
					.getArticleContentByArticleId(articleId);
		}
		return "articleContentAddOrEdit";
	}

	public String UploadImage() {
		System.out.println(imageUpload);
			
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		FileItemFactory factory = new DiskFileItemFactory(); 
		
		ServletFileUpload upload = new ServletFileUpload(factory);  
		try {
		List<?> items = upload.parseRequest(request);
		Iterator iter = items.iterator();  
		while(iter.hasNext()){
		FileItem item = (FileItem) iter.next();
		if (item.isFormField()) {  
		       //如果是普通表单字段  
		       String name = item.getFieldName();  
		        String value = item.getString();  
		   } else {
		    String fieldName = item.getFieldName();  
		           String fileName = item.getName();  
		           String contentType = item.getContentType();  
		           boolean isInMemory = item.isInMemory();  
		           long sizeInBytes = item.getSize(); 
		           String imgPath=request.getSession().getServletContext().getRealPath("/WeixinPages/uploadImg") ;//request.getRealPath("/")
		           File uploadedFile = new File( imgPath+"/"+fileName);  
		               try {  
		                   item.write(uploadedFile);  
		                   System.out.println("图片保存成功，路径"+imgPath+ fileName);
		               } catch (Exception e) {
		                   // TODO Auto-generated catch block  
		                   e.printStackTrace();  
		               }  
		   }

		}
		} catch (FileUploadException e) {
		e.printStackTrace();
		}
		
		
		return "success";
	}

}
