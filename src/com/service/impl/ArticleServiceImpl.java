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
		MyArticleContent mac=new MyArticleContent();
		mac.setMyArticle(ma);
		articleDAO.updateArticleContent(mac);
		articleDAO.updateArticle(ma);
	}

	public int addArticle(MyArticle ma) {
		// TODO Auto-generated method stub
		ma.setArticleId(null);
		int id=articleDAO.addArticle(ma);
		ma.setArticleId(id);
		MyArticleContent mac=new MyArticleContent();
		mac.setMyArticle(ma);
		articleDAO.addArticleContent(mac);
		return id;
	}

	public void updateArticleContent(MyArticleContent articleContentBuff) {
		// TODO Auto-generated method stub
		articleDAO.updateArticleContent(articleContentBuff);
	}

	
	


}
