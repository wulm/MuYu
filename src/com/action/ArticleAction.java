package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.bean.MyArticle;
import com.service.IArticleService;
import com.service.IUserService;

public class ArticleAction { 

	private IArticleService articleService;//微信新闻类业务

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	
	public String deleteArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		articleService.deleteArticle(articleId);
		List<MyArticle> allArticles=articleService.getByType(-1);
		request.getSession().setAttribute("allArticles", allArticles);
		return "articleManage";
	}
	
	public String gotoAddArticle(){
		return "";
	}
	
	public String gotoEditArticle(){
		return "";
	}
	
	public String getArticleByType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleType=Integer.parseInt(request.getParameter("articleType"));
		List<MyArticle> articles=articleService.getByType(articleType);
		return "articleList";
	}
	
}
