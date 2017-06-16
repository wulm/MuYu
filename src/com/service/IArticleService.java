package com.service;

import java.util.List;

import com.bean.MyArticle;


public interface IArticleService {

	void deleteArticle(int articleId);

	List<MyArticle> getByType(int articleType);

}
