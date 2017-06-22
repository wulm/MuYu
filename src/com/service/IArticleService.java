package com.service;

import java.util.List;

import com.bean.MyArticle;
import com.bean.MyArticleContent;


public interface IArticleService {

	void deleteArticle(int articleId);

	List<MyArticle> getByType(int articleType);

	MyArticleContent getArticleContentByArticleId(int articleId);

	MyArticle getArticleByArticleId(int articleId);

	void updateArticle(MyArticle ma);

	void addArticle(MyArticle ma);

}
