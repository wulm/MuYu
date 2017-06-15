package com.service;

import javax.servlet.http.HttpServletRequest;

public interface IWeixinService {

	//微信核心消息处理service
	String processRequest(HttpServletRequest request);
}
