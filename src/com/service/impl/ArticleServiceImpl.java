package com.service.impl;

import java.util.List;

import com.bean.MyArticle;
import com.bean.MyArticleContent;
import com.dao.IArticleDAO;

public class ArticleServiceImpl implements com.service.IArticleService{

	private IArticleDAO articleDAO;//“¿¿µ◊¢»Î”√ªßdao

	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		
		articleDAO.deleteArticle(articleId);
		
	}

	public List<MyArticle> getByType(int articleType) {
		// TODO Auto-generated method stub
		return articleDAO.getByType(articleType);
	}

	public MyArticleContent getArticleContentByArticleId(int articleId) {
		// TODO Auto-generated method stub
		return articleDAO.getArticleContentByArticleId(articleId);
	}

	public MyArticle getArticleByArticleId(int articleId) {
		// TODO Auto-generated method stub
		return articleDAO.getArticleByArticleId(articleId);
	}

	public void updateArticle(MyArticle ma) {
		// TODO Auto-generated method stub
		articleDAO.updateArticle(ma);
	}

	public void addArticle(MyArticle ma) {
		// TODO Auto-generated method stub
		articleDAO.addArticle(ma);
	}

	
	


}
