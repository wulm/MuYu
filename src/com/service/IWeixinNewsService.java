package com.service;

import javax.servlet.http.HttpServletRequest;

import com.bean.MxNewsData;

/**
 * 新闻业务
 * @author zw
 *
 */

public interface IWeixinNewsService {

	//添加新闻
	void addNews(MxNewsData newsData);
}
