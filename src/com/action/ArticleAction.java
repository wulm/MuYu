package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.multipart.MultipartFile;

import com.bean.MyArticle;
import com.bean.MyArticleContent;
import com.service.IArticleService;

public class ArticleAction { 

	private IArticleService articleService;//������ҵ��

	private List<MyArticle> articleList;//�����б�
	
	private MyArticle article;//��������
	
	private MyArticleContent articleContent;//�������¾�������
	
	private int articleType;//�������
	
	private File imageUpload;//ͼƬ�ϴ�buffer
	
	private String imageUploadFileName;//ͼƬ�ļ���
	
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
	
	public String deleteArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		articleType=Integer.parseInt(request.getParameter("articleType"));
		articleService.deleteArticle(articleId);
		articleList=articleService.getByType(articleType);
		
		return "articleEditList";
	}
	
	public String gotoArticleEditList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType=Integer.parseInt(request.getParameter("articleType"));
		articleList=articleService.getByType(articleType);
		return "articleEditList";
	}
	
	public String gotoArticleUserList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType=Integer.parseInt(request.getParameter("articleType"));
		articleList=articleService.getByType(articleType);
		return "articleUserList";
	}
	
	public String gotoArticleUserContent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		MyArticleContent article=articleService.getArticleContentByArticleId(articleId);
		request.getSession().setAttribute("article", article);
		return "articleDetail";
	}
	
	public String gotoAddArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id=request.getParameter("articleId");
		if(null!=id){
			int articleId=Integer.parseInt(id);
			article=articleService.getArticleByArticleId(articleId);
		}
		return "articleAddOrEdit";
	}
	
	public String gotoEditArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		article=articleService.getArticleByArticleId(articleId);
		return "articleAddOrEdit";
	}
	
	public String getArticleByType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		articleType=Integer.parseInt(request.getParameter("articleType"));
		List<MyArticle> articles=articleService.getByType(articleType);
		return "articleList";
	}

	public String DoAddArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		return "";
	}
	
	
	public String DoSaveArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId=Integer.parseInt(request.getParameter("articleId")==null?"-100":request.getParameter("articleId"));
		int articleType=Integer.parseInt(request.getParameter("articleType"));
		String articleTitle=request.getParameter("articleTitle");
		String writerName=request.getParameter("writerName");
		String articleLeadText=request.getParameter("articleLeadText");
		String articleTitleImageUrl=request.getParameter("articleTitleImageUrl");
		String createDate=request.getParameter("createDate");
		MyArticle ma=new MyArticle(articleId,writerName,articleType,
				articleTitle,articleTitleImageUrl,
				articleLeadText, Timestamp.valueOf(createDate),
				new Timestamp(System.currentTimeMillis()),0);
		if(articleId==-100){
			articleService.addArticle(ma);
		}else{
			articleService.updateArticle(ma);
			articleContent=articleService.getArticleContentByArticleId(articleId);
		}
		return "articleContentAddOrEdit";
	}
	
	
	public String UploadImage() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String uuid = UUID.randomUUID().toString().replace("-", "");//�������ļ����ļ���
        InputStream is=new FileInputStream(imageUpload);//��<input>��ǩ�����ͼƬ�ļ�д�����ļ�InpuStream
        String uploadPath=ServletActionContext.getServletContext().getRealPath("/WeixinPages/uploadImg/");
        File toFile=new File(uploadPath,this.getImageUploadFileName());//Ŀ���ļ������ļ�λ�ú��ļ����������ļ����ļ��������
        /**
         * ��δ��������������ļ��������ļ�������
         */
        int pot=toFile.getName().lastIndexOf(".");  
        String ext="";
          if(pot!=-1){  
              ext=toFile.getName().substring(pot);  
          }else{  
              ext="";  
          }  
          String newName=uuid+ext;  
          toFile=new File(toFile.getParent(),newName); //�������ļ����
          /**
           * ���ͻ��˵Ķ�����������д�뵽����������
           */
        OutputStream os=new FileOutputStream(toFile);
        byte[] buffer=new byte[1024];//����ռ��С ��λΪKB
        int length=0;
        while((length=is.read(buffer))>0){
            os.write(buffer,0, length);
        }
        is.close();
        os.close();  //�ļ�д�뱾�����

        String webRoot=request.getSession().getServletContext().getRealPath("/");//��ȡ�ļ��ڷ�������Ŀ�ļ��еľ���·��
        String basePath="/photos/"+toFile.getName();//�ļ������·��
        String url=webRoot+basePath;//�ļ�������·����������������ֻ��Ҫ���������·���������ݿ⼴��
        PrintWriter out=response.getWriter();
        out.print(url);
        out.print("||success");

       // return null;

		return "";
	}

	


	
}
