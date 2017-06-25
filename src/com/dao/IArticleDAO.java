package com.dao;

import java.util.List;

import com.bean.MyArticle;
import com.bean.MyArticleContent;

/**
 * ÎÄÕÂdao
 * @author zw
 *
 */

public interface IArticleDAO {

	void deleteArticle(int articleId);
	
	public List<MyArticle> getByType(int articleType);

	MyArticleContent getArticleContentByArticleId(int articleId);

	MyArticle getArticleByArticleId(int articleId);

	void updateArticle(MyArticle ma);

	int addArticle(MyArticle ma);

	void addArticleContent(MyArticleContent mac);

	void updateArticleContent(MyArticleContent mac);
	
}
