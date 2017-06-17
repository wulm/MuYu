package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.bean.MyArticle;
import com.bean.MyArticleContent;
import com.service.IArticleService;
import com.service.IUserService;

public class ArticleAction { 

	private IArticleService articleService;//΢��������ҵ��

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
		List<MyArticle> articleList=articleService.getByType(-1);
		request.getSession().setAttribute("articleList", articleList);
		return "articleManage";
	}
	
	public String gotoArticleList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleType=Integer.parseInt(request.getParameter("articleType"));
		List<MyArticle> articleList=articleService.getByType(articleType);
		request.getSession().setAttribute("articleList", articleList);
		request.getSession().setAttribute("articleType", articleType);
		return "articleList";
	}
	
	public String gotoArticleDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		MyArticleContent article=articleService.getArticleByArticleId(articleId);
		request.getSession().setAttribute("article", article);
		return "articleDetail";
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
