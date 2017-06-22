package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.MyArticle;
import com.bean.MyArticleContent;
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
		//Object rs=sqlUtil.queryHqlBySession("delete from [TestMuYu].[dbo].[MY_article_content] where article_id="+articleId);
		//getHibernateTemplate().delete(getHibernateTemplate().get(MyArticleContent.class , articleId));
		getHibernateTemplate().flush();
	}
	
	
	
	public List<MyArticle> getByType(int articleType) {
		return getHibernateTemplate().find("from com.bean.MyArticle ma where 1=1 "+(articleType==-1?"":"and ma.articleType="+articleType));
	}
	
	
	public MyArticleContent getArticleContentByArticleId(int articleId) {
		// TODO Auto-generated method stub
		List<MyArticleContent> ma= getHibernateTemplate().find("from com.bean.MyArticleContent mac where article_id= "+articleId);
		if(ma.size()>0){
			return ma.get(0);
		}else{
			return null;
		}
	}
	public MyArticle getArticleByArticleId(int articleId) {
		// TODO Auto-generated method stub
		List<MyArticle> ma= getHibernateTemplate().find("from com.bean.MyArticle ma where article_id= "+articleId);
		if(ma.size()>0){
			return ma.get(0);
		}else{
			return null;
		}
	}
	
	public void updateArticle(MyArticle article){
		getHibernateTemplate().update(article);
	}
	public void addArticle(MyArticle ma) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(ma);
	}
	
}
