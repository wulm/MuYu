package com.service.impl;

import com.dao.IUserDAO;

public class UserServiceImpl implements com.service.IUserService{

	private IUserDAO userDAO;//����ע���û�dao

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	/*//�������
	public void addNews(MxNewsData newsData) {
        System.out.println("service");
        System.out.println(newsData.toString());
		weixinNewsDAO.addNews(newsData);
	}*/


}
