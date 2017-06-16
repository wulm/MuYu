package com.service.impl;

import com.dao.IUserDAO;

public class UserServiceImpl implements com.service.IUserService{

	private IUserDAO userDAO;//依赖注入用户dao

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	/*//添加新闻
	public void addNews(MxNewsData newsData) {
        System.out.println("service");
        System.out.println(newsData.toString());
		weixinNewsDAO.addNews(newsData);
	}*/


}
