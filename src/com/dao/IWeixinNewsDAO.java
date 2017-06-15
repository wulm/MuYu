package com.dao;

import com.bean.MxNewsData;

/**
 * 新闻业务类dao
 * @author zw
 *
 */

public interface IWeixinNewsDAO {

	/**
     * 添加新闻
     * @param
     */ 
	public void addNews(MxNewsData newsData);
	
	
}
