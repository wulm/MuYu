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
import com.weixin.pojo.SNSUserInfo;
import com.weixin.pojo.WeixinOauth2Token;
import com.weixin.pojo.WeixinUserInfo;
import com.weixin.task.WeixinGetTokenTimerTask;
import com.weixin.util.MessageUtil;
import com.weixin.util.OAuth2TokenUtil;
import com.weixin.util.ResultUtil;
import com.weixin.util.WeixinSignUtil;
import com.weixin.util.WeixinUtil;

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
	

	/**
	 * ����*΢��action�еĴ����� ����
	 */
	public String execute() throws Exception {
        System.out.println("exec");   
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// ���ղ���΢�ż���ǩ���� ʱ����������
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");

		// ����ַ���
		String echostr = request.getParameter("echostr");
		// System.out.println(signature+"...............................");
		PrintWriter out = response.getWriter();
		
		//���ز���
		String respParams= null;
//		if(1==1){
//			String respXml = weixinService.processRequest(request);
//			return "notMyUser";
//		}
		// ����У��
		if (WeixinSignUtil.checkSignature(signature, timestamp, nonce)) {
			String method = ServletActionContext.getRequest().getMethod();
			if (method.equals("POST")) {
				// ���ú��ķ�������մ�������
				String respXml = weixinService.processRequest(request);
				out.print(respXml);
			} else {
				out.print(echostr);
			}

		}
		out.close();
		out = null;
		return respParams;
	}

	public String getWebAccessToken() throws ServletException, IOException {
       
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// �û�ͬ����Ȩ���ܻ�ȡ��code
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		if (!"authdeny".equals(code)) {
			// ��ȡ��ҳ��Ȩaccess_token
			WeixinOauth2Token weixinOauth2Token = OAuth2TokenUtil
					.getOauth2AccessToken(WeixinSignUtil.AppID,
							WeixinSignUtil.AppSecret, code);
			// ��ҳ��Ȩ�ӿڷ���ƾ֤
			String accessToken = weixinOauth2Token.getAccessToken();
			// �û���ʶ
			String openId = weixinOauth2Token.getOpenId();
			// ��ȡ�û���Ϣ
			SNSUserInfo snsUserInfo = OAuth2TokenUtil.getSNSUserInfo(
					accessToken, openId);
			System.out.println(snsUserInfo.getOpenId() + ","
					+ snsUserInfo.getNickname() + ","
					+ snsUserInfo.getHeadImgUrl());
			// ����Ҫ���ݵĲ���
			request.setAttribute("snsUserInfo", snsUserInfo);
			request.setAttribute("state", state);
		}
		// ��ת��index.jsp
		//request.getRequestDispatcher("login.jsp").forward(request, response);

		return "weixinHome";
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
		
		SNSUserInfo snsUserInfo = new SNSUserInfo();
		//ͨ��code��ȡ�û���Ϣ
		if (!"authdeny".equals(code)) {
			// ��ȡ��ҳ��Ȩaccess_token
			WeixinOauth2Token weixinOauth2Token = OAuth2TokenUtil
					.getOauth2AccessToken(WeixinSignUtil.AppID,
							WeixinSignUtil.AppSecret, code);
			// ��ҳ��Ȩ�ӿڷ���ƾ֤
			String accessToken = weixinOauth2Token.getAccessToken();
			// �û���ʶ
			String openId = weixinOauth2Token.getOpenId();
			// ��ȡ�û���Ϣ
			snsUserInfo = OAuth2TokenUtil.getSNSUserInfo(
					accessToken, openId);
			System.out.println(snsUserInfo.getOpenId() + ","
					+ snsUserInfo.getNickname() + ","
					+ snsUserInfo.getHeadImgUrl());
		}
		
		//�������
		MxNewsData newsData = new MxNewsData();
		newsData.setNewsHeadline(newsHeadline);
		newsData.setNewsMainContent(newsMainContent);
		//newsData.setNewsWriterId(snsUserInfo.getOpenId());
		newsData.setWriterName(snsUserInfo.getNickname());
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
	
	//ͨ��code��ȡ�û���Ϣ��װ
	SNSUserInfo getUserInfo(String code){
		SNSUserInfo snsUserInfo = new SNSUserInfo();
		//ͨ��code��ȡ�û���Ϣ
		if (!"authdeny".equals(code)) {
			// ��ȡ��ҳ��Ȩaccess_token
			WeixinOauth2Token weixinOauth2Token = OAuth2TokenUtil
					.getOauth2AccessToken(WeixinSignUtil.AppID,
							WeixinSignUtil.AppSecret, code);
			// ��ҳ��Ȩ�ӿڷ���ƾ֤
			String accessToken = weixinOauth2Token.getAccessToken();
			// �û���ʶ
			String openId = weixinOauth2Token.getOpenId();
			// ��ȡ�û���Ϣ
			snsUserInfo = OAuth2TokenUtil.getSNSUserInfo(
					accessToken, openId);
			System.out.println(snsUserInfo.getOpenId() + ","
					+ snsUserInfo.getNickname() + ","
					+ snsUserInfo.getHeadImgUrl());
		}
		
		return snsUserInfo;
	}
}
