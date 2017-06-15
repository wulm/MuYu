package com.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.MxNewsData;
import com.dao.IWeixinNewsDAO;
import com.publicMethos.ISqlUtil;

public class WeixinNewsDAOImpl extends HibernateDaoSupport implements IWeixinNewsDAO {

	public static final int pageLinesNum=3;//定义每个页面显示的列表行数
	public static final String DB_table_name="[JC_Web_System_DB].[dbo].[Sys_Users]";//用户数据库及数据表名称
	public static final String Primarykey="user_id";//用户数据表主键名称
	private ISqlUtil sqlUtil;//依赖注入执行自定义sql语句的通用类
	
	public ISqlUtil getSqlUtil() {
		return sqlUtil;
	}
	public void setSqlUtil(ISqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	//添加新闻
	public void addNews(MxNewsData newsData) {
		System.out.println("dao");
		try{
			getHibernateTemplate().save(newsData);
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			System.out.println(e.getMessage());
			//System.out.println(e.printStackTrace());
		}


	}



}
