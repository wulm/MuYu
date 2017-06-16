package com.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.service.IUserService;

public class UserAction { 

	private IUserService userService;//微信新闻类业务

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	//登录后台管理文章
	public String login(){
		System.out.println("user login");
		HttpServletRequest request = ServletActionContext.getRequest();
		String username= request.getAttribute("username").toString();
		String password=request.getAttribute("password").toString();
		return "addNews";
	}

	
	
}
