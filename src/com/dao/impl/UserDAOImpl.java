package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.MyUsers;
import com.dao.IUserDAO;
import com.publicMethos.ISqlUtil;

public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	private ISqlUtil sqlUtil;//依赖注入执行自定义sql语句的通用类
	
	public ISqlUtil getSqlUtil() {
		return sqlUtil;
	}
	public void setSqlUtil(ISqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public boolean validUser(String username, String password) {
		// TODO Auto-generated method stub
		List<MyUsers> mu = getHibernateTemplate().find("from com.bean.MyUsers au where au.userName = '"+ username+"' and au.userPwd = '"+ password+"'");
		if(mu.size()!=0){
			return true;
		}else{
			return false;
		}
	}


}
