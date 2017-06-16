package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.bean.MyArticle;
import com.service.IArticleService;
import com.service.IUserService;

public class UserAction { 

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	private IArticleService articleService;
	
	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	
	//登录后台管理文章
	public String login(){
		System.out.println("user login");
		HttpServletRequest request = ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean validLogin=userService.validUser(username,password);
		if(validLogin){
			List<MyArticle> allArticles=articleService.getByType(-1);
			request.getSession().setAttribute("allArticles", allArticles);
			return "loginSuccess";
		}else{
			return "loginFail";
		}
		
	}

	
	
}
