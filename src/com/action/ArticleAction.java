package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.bean.MyArticle;
import com.bean.MyArticleContent;
import com.service.IArticleService;
import com.service.IUserService;

public class ArticleAction { 

	private IArticleService articleService;//������ҵ��

	private List<MyArticle> articleList;//�����б�
	
	private MyArticle article;//��������
	
	private MyArticleContent articleContent;//�������¾�������
	
	private int articleType;//�������
	
	
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
		
		return "";
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

	
	
}