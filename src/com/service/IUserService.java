package com.service;

import java.util.List;

import com.bean.MxUsersData;
import com.bean.PageBean;
import com.dao.ISysUsersDAO;

public interface IUserService {

	public List<MxUsersData> getAllUsers();
	MxUsersData validLogin(String username , String password);
	public ISysUsersDAO getSysUsersDAO();
	public void setSysUsersDAO(ISysUsersDAO userDAO);
	MxUsersData getUserByID(Integer userId);
	PageBean queryForPage(int pageCurrent);
	public boolean validateWeixinUser(String openId);
	
}
