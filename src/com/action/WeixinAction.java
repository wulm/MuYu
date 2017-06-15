package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.bean.MxNewsData;
import com.service.IWeixinNewsService;
import com.service.IWeixinService;

public class WeixinAction { 

	private static final long serialVersionUID = -1627548805862485475L;

	private IWeixinService weixinService;
	private IWeixinNewsService weixinNewsService;//微信新闻类业务
	
	public IWeixinService getWeixinService() {
		return weixinService;
	}

	public IWeixinNewsService getWeixinNewsService() {
		return weixinNewsService;
	}

	public void setWeixinNewsService(IWeixinNewsService weixinNewsService) {
		this.weixinNewsService = weixinNewsService;
	}

	public void setWeixinService(IWeixinService weixinService) {
		this.weixinService = weixinService;
	}
	
	
	//鸣心时报乡村时报主页跳转方法
	public String getCountryNews(){
		return "countryNews";
	}
	
	
	//鸣心时报学校时报主页跳转方法
	public String getSchoolNews(){
			return "schoolNews";
	}
	
	//未关注进入公众号
	public String getNotMyUser(){
			return "notMyUser";
	}
	
	//新闻投稿页面
	public String loadAddNews(){
		System.out.println("getadd");
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
			//获取code
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			// 设置要传递的参数
			System.out.println(code);
			System.out.println(state);
			request.setAttribute("code", code);
			request.setAttribute("state", state);
//			request.setAttribute("snsUserInfo", getUserInfo(code).getNickname());//通过code获取用户信息
			
			//通过code获取用户信息
			if (!"authdeny".equals(code)) {
//				// 获取网页授权access_token
//				WeixinOauth2Token weixinOauth2Token = OAuth2TokenUtil
//						.getOauth2AccessToken(WeixinSignUtil.AppID,
//								WeixinSignUtil.AppSecret, code);
//				// 网页授权接口访问凭证
//				String accessToken = weixinOauth2Token.getAccessToken();
//				// 用户标识
//				String openId = weixinOauth2Token.getOpenId();
//				// 获取用户信息
//				SNSUserInfo snsUserInfo = OAuth2TokenUtil.getSNSUserInfo(
//						accessToken, openId);
//				System.out.println(snsUserInfo.getOpenId() + ","
//						+ snsUserInfo.getNickname() + ","
//						+ snsUserInfo.getHeadImgUrl());
//				// 设置要传递的参数
//				request.setAttribute("snsUserInfo", snsUserInfo);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "addNews";
	}
	
	//添加新闻
	public String addNews() throws UnsupportedEncodingException{
		//获取用户信息
		//获取参数
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String newsHeadline = request.getParameter("title");
		String newsMainContent = request.getParameter("content");
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		System.out.println(newsHeadline+","+newsMainContent+","+code+","+state);
		//通过code获取用户信息
		//System.out.println(getUserInfo(code).getNickname()+","+getUserInfo(code).getOpenId());
		
		
		//添加新闻
		MxNewsData newsData = new MxNewsData();
		newsData.setNewsHeadline(newsHeadline);
		newsData.setNewsMainContent(newsMainContent);
		//newsData.setNewsWriterId(snsUserInfo.getOpenId());
		//newsData.setWriterName(snsUserInfo.getNickname());
		weixinNewsService.addNews(newsData);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", newsHeadline);
		try {
			ResultUtil.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//新闻投稿页面
	public String getResultPage(){
		return "resultPage";
	}
	
	
}
