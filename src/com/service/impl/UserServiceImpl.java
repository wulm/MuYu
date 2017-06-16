package com.service.impl;

import com.dao.IUserDAO;

public class UserServiceImpl implements com.service.IUserService{

	private IUserDAO userDAO;//“¿¿µ◊¢»Î”√ªßdao

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean validUser(String username, String password) {
		// TODO Auto-generated method stub
		boolean validUser=userDAO.validUser(username,password);
		if(validUser){
			return true;
		}else{
			return false;
		}
	}



}
