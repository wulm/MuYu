package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.bean.MyArticle;
import com.dao.IArticleDAO;
import com.publicMethos.ISqlUtil;

public class ArticleDAOImpl extends HibernateDaoSupport implements IArticleDAO {

	private ISqlUtil sqlUtil;//依赖注入执行自定义sql语句的通用类
	
	public ISqlUtil getSqlUtil() {
		return sqlUtil;
	}
	public void setSqlUtil(ISqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(MyArticle.class , articleId));
	}
	
	
	public List<MyArticle> getByType(int articleType) {
		return getHibernateTemplate().find("from com.bean.MyArticle ma where 1=1 "+(articleType==-1?"":"and ma.articleType="+articleType));
	}
}
