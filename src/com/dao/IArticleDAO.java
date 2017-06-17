package com.dao;

import java.util.List;

import com.bean.MyArticle;
import com.bean.MyArticleContent;

/**
 * ндубdao
 * @author zw
 *
 */

public interface IArticleDAO {

	void deleteArticle(int articleId);
	
	public List<MyArticle> getByType(int articleType);

	MyArticleContent getByArticleId(int articleId);
	
}
