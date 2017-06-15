package com.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.MxNewsData;
import com.dao.IWeixinNewsDAO;
import com.publicMethos.ISqlUtil;

public class WeixinNewsDAOImpl extends HibernateDaoSupport implements IWeixinNewsDAO {

	public static final int pageLinesNum=3;//����ÿ��ҳ����ʾ���б�����
	public static final String DB_table_name="[JC_Web_System_DB].[dbo].[Sys_Users]";//�û����ݿ⼰���ݱ�����
	public static final String Primarykey="user_id";//�û����ݱ���������
	private ISqlUtil sqlUtil;//����ע��ִ���Զ���sql����ͨ����
	
	public ISqlUtil getSqlUtil() {
		return sqlUtil;
	}
	public void setSqlUtil(ISqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	//�������
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
