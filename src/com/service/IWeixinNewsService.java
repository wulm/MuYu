package com.service;

import javax.servlet.http.HttpServletRequest;

import com.bean.MxNewsData;

/**
 * ����ҵ��
 * @author zw
 *
 */

public interface IWeixinNewsService {

	//�������
	void addNews(MxNewsData newsData);
}
