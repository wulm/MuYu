package com.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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


}
