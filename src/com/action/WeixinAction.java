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
	private IWeixinNewsService weixinNewsService;//΢��������ҵ��
	
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
	
	
	//����ʱ�����ʱ����ҳ��ת����
	public String getCountryNews(){
		return "countryNews";
	}
	
	
	//����ʱ��ѧУʱ����ҳ��ת����
	public String getSchoolNews(){
			return "schoolNews";
	}
	
	//δ��ע���빫�ں�
	public String getNotMyUser(){
			return "notMyUser";
	}
	
	//����Ͷ��ҳ��
	public String loadAddNews(){
		System.out.println("getadd");
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
			//��ȡcode
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			// ����Ҫ���ݵĲ���
			System.out.println(code);
			System.out.println(state);
			request.setAttribute("code", code);
			request.setAttribute("state", state);
//			request.setAttribute("snsUserInfo", getUserInfo(code).getNickname());//ͨ��code��ȡ�û���Ϣ
			
			//ͨ��code��ȡ�û���Ϣ
			if (!"authdeny".equals(code)) {
//				// ��ȡ��ҳ��Ȩaccess_token
//				WeixinOauth2Token weixinOauth2Token = OAuth2TokenUtil
//						.getOauth2AccessToken(WeixinSignUtil.AppID,
//								WeixinSignUtil.AppSecret, code);
//				// ��ҳ��Ȩ�ӿڷ���ƾ֤
//				String accessToken = weixinOauth2Token.getAccessToken();
//				// �û���ʶ
//				String openId = weixinOauth2Token.getOpenId();
//				// ��ȡ�û���Ϣ
//				SNSUserInfo snsUserInfo = OAuth2TokenUtil.getSNSUserInfo(
//						accessToken, openId);
//				System.out.println(snsUserInfo.getOpenId() + ","
//						+ snsUserInfo.getNickname() + ","
//						+ snsUserInfo.getHeadImgUrl());
//				// ����Ҫ���ݵĲ���
//				request.setAttribute("snsUserInfo", snsUserInfo);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "addNews";
	}
	
	//�������
	public String addNews() throws UnsupportedEncodingException{
		//��ȡ�û���Ϣ
		//��ȡ����
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String newsHeadline = request.getParameter("title");
		String newsMainContent = request.getParameter("content");
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		System.out.println(newsHeadline+","+newsMainContent+","+code+","+state);
		//ͨ��code��ȡ�û���Ϣ
		//System.out.println(getUserInfo(code).getNickname()+","+getUserInfo(code).getOpenId());
		
		
		//�������
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
	
	
	//����Ͷ��ҳ��
	public String getResultPage(){
		return "resultPage";
	}
	
	
}
