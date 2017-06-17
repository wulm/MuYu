package com.service;

import java.util.List;

import com.bean.MyArticle;
import com.bean.MyArticleContent;


public interface IArticleService {

	void deleteArticle(int articleId);

	List<MyArticle> getByType(int articleType);

	MyArticleContent getArticleByArticleId(int articleId);

}
