package com.service.impl;




import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bean.MxNewsData;
import com.dao.IWeixinNewsDAO;
import com.weixin.pojo.WeixinUserInfo;
import com.weixin.task.WeixinGetTokenTimerTask;
import com.weixin.util.MessageUtil;
import com.weixin.util.WeixinUtil;


public class WeixinNewsServiceImpl implements com.service.IWeixinNewsService{

	private IWeixinNewsDAO weixinNewsDAO;//依赖注入用户dao

	public IWeixinNewsDAO getWeixinNewsDAO() {
		return weixinNewsDAO;
	}

	public void setWeixinNewsDAO(IWeixinNewsDAO weixinNewsDAO) {
		this.weixinNewsDAO = weixinNewsDAO;
	}

	//添加新闻
	public void addNews(MxNewsData newsData) {
        System.out.println("service");
        System.out.println(newsData.toString());
		weixinNewsDAO.addNews(newsData);
	}


}
