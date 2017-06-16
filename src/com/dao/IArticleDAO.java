package com.dao;

import java.util.List;

import com.bean.MyArticle;

/**
 * ндубdao
 * @author zw
 *
 */

public interface IArticleDAO {

	void deleteArticle(int articleId);
	
	public List<MyArticle> getByType(int articleType);
	
}
