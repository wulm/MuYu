package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bean.MxUsersData;
import com.dao.ISysUsersDAO;
import com.weixin.message.req.LinkMessage;
import com.weixin.message.resp.Article;
import com.weixin.message.resp.NewsMessage;
import com.weixin.message.resp.TextMessage;
import com.weixin.pojo.SNSUserInfo;
import com.weixin.pojo.WeixinOauth2Token;
import com.weixin.pojo.WeixinUserInfo;
import com.weixin.task.WeixinGetTokenTimerTask;
import com.weixin.util.MessageUtil;
import com.weixin.util.OAuth2TokenUtil;
import com.weixin.util.WeixinSignUtil;
import com.weixin.util.WeixinUtil;

public class WeixinServiceImpl implements com.service.IWeixinService{

	private ISysUsersDAO sysUsersDAO;//����ע���û�dao
	
	public String processRequest(HttpServletRequest request) {
		System.out.println("process");
		// TODO Auto-generated method stub
		System.out.println("΢���û���������");
		// xml��ʽ����Ϣ����
        String respXml = null;
        // Ĭ�Ϸ��ص��ı���Ϣ����
        String respContent = "δ֪����Ϣ���ͣ�";
        try {
        	
            // ����parseXml��������������Ϣ
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            
            // ���ͷ��ʺ�openid
            String fromUserName = requestMap.get("FromUserName");
            //System.out.println("���ͷ��˺ţ�"+fromUserName);
            
            // ������΢�ź�
            String toUserName = requestMap.get("ToUserName");
            //System.out.println("������΢�źţ�"+toUserName);
            
            // ��Ϣ����
            String msgType = requestMap.get("MsgType");
            
            //��ȡ�����û���Ϣ
            WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);

            // �ظ��ı���Ϣ
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // �ı���Ϣ
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	String content=requestMap.get("Content");
            	if("1".equals(content)){
            		respContent = "��Ͷ�Ÿ��˼�����mingxin2017@yahoo.com�����ǽ�����������ϵ����������ڴ���ļ��룡";
            	}else if("2".equals(content)){
            		respContent = "���Ͷ������ϵ18888888888�����Ľ���ֿ����������";
            	}else if("3".equals(content)){
            		respContent = "�����Ļ����޹�˾��ַ�������سǶ��ֵ�����·8�ţ���������352200";
            	}else{
            		respContent = "�ظ�����,��л�������ĵĹ�ע��";
            	}
                
                //���Ի�ȡ�û���ϸ��Ϣ
//                WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);
//                System.out.println(wui.getNickname());
//                System.out.println(wui.getSex());
//                System.out.println(wui.getCity());
//                System.out.println(wui.getOpenId());
//                System.out.println(wui.getHeadImgUrl());
//                System.out.println(wui.getProvince());
                
            }
            // ͼƬ��Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "�����͵���ͼƬ��Ϣ��";
            }
            // ������Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "�����͵���������Ϣ��";
            }
            // ��Ƶ��Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "�����͵�����Ƶ��Ϣ��";
            }
            // ��Ƶ��Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                respContent = "�����͵���С��Ƶ��Ϣ��";
            }
            // ����λ����Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "�����͵��ǵ���λ����Ϣ��";
            }
            // ������Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "�����͵���������Ϣ��";
            }
            // �¼�����
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // �¼�����
                String eventType = requestMap.get("Event");
                // ��ע
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "���ڵȵ��㣡��";
                    
                    //�û���ע�󣬼��ɳ�Ϊϵͳ��ͨ�û�
                  //��ȡ�û�΢�ź���ϸ��Ϣ
                    //WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);
                    System.out.println(wui.getNickname());
                    System.out.println(wui.getSex());
                    System.out.println(wui.getCity());
                    System.out.println(wui.getOpenId());
                    System.out.println(wui.getHeadImgUrl());
                    System.out.println(wui.getProvince());
                    
                    System.out.println("�û���ע���ںţ��Զ����Ϊϵͳ��ͨ�û�");
                    
                    MxUsersData user=new MxUsersData();
                    user.setWeixinNikeName(wui.getNickname());
                    user.setWeixinOpenId(wui.getOpenId());
                    user.setWeixinHeadUrl(wui.getHeadImgUrl());
                    MxUsersData ur=sysUsersDAO.getUserByOpenId(wui.getOpenId());
                    if(ur==null){
                    	sysUsersDAO.addUser(user);
                        System.out.println("΢�Ź�ע���û���ӳɹ�");
                    }else if(ur.getUserState()==-1){
                    	ur.setUserState(0);
                    	sysUsersDAO.setUserState(ur);
                    }
                    
                    
                }
                // ȡ����ע
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                	//WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);
                	MxUsersData ur=sysUsersDAO.getUserByOpenId(wui.getOpenId());
                	if(ur!=null){
                		ur.setUserState(-1);
                		sysUsersDAO.setUserState(ur);
                	}
                    // TODO ȡ�����ĺ��û��������յ������˺ŷ��͵���Ϣ����˲���Ҫ�ظ�,�����ݿ����û�״̬��Ϊ-1
                }
                // ɨ���������ά��
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO ����ɨ���������ά���¼�
                	respContent = "ɨ���˶�ά�룡";
                }
                // �ϱ�����λ��
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    // TODO �����ϱ�����λ���¼�
                	respContent = "�ϱ�����λ�ã�";
                }
                // �Զ���˵�
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO ����˵�����¼�
                	respContent = "�˵�����¼���";
                	String eventKey=requestMap.get("EventKey");
                	System.out.println("eventKeyֵΪ"+ requestMap.get("EventKey"));
                	
                	//����Ͷ��
                	if(eventKey.equals("32")){ 
                		//�����û��Ƿ��ע���ں�
                        //���Ի�ȡ�û���ϸ��Ϣ
                        System.out.println(wui.getNickname());
                        System.out.println(wui.getSex());
                        System.out.println(wui.getCity());
                        System.out.println(wui.getOpenId());
                        System.out.println(wui.getHeadImgUrl());
                        System.out.println(wui.getProvince());
                        //У���û�
                        int isExistUser = sysUsersDAO.isExistUser(wui.getOpenId());
                        if(isExistUser == 0){
                        	//����δ��ע����ͼ��  ���ڸĳɶ�ά��ͼ��
                            NewsMessage newsMessage = new NewsMessage();
                            newsMessage.setToUserName(fromUserName);
                            newsMessage.setFromUserName(toUserName);
                            newsMessage.setCreateTime(new Date().getTime());
                            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                            Article article = new Article();
                            article.setTitle("�ż���ȥ�Ķ�ح��������Ӫ��Ӫ����");
                            article.setDescription("�������� 2017�����ľ�������Ӫ���켯��� ������ഺ����ɫ�ľ�Ӫ�ﱼ�ܰɣ�");
                            article.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/FepiawovpW9miaLzBlGgjtBtbMP2Af484AfWTtxIpRrLZtib7u0gHoTwocHxfFMLgibkEb5zUI28UoQ49PySBN3VGg/0?wx_fmt=jpeg");
                            article.setUrl("http://mp.weixin.qq.com/s?__biz=MzIxMjgxNjcyNg==&mid=100000093&idx=1&sn=4029a17482fbdc054b9666464f2dc2f4&chksm=1741076420368e72f2f35266e554089ceaba4e33fe770e5e7a77c1b30aaed485bc8348f6a536#rd");
                            List<Article> articles = new ArrayList<Article>();
                            articles.add(article);
                    		newsMessage.setArticles(articles);
                    		newsMessage.setArticleCount(1);
                    		respXml = MessageUtil.messageToXml(newsMessage);
                    		return respXml;
                        }else{
                        	System.out.println(isExistUser);
                        	
                        }
                        //У��ͨ����ת�����������
                        //У��ʧ����ʾ��ע���ںź��ٽ��в���
                	}
                	//������չ
                	if(eventKey.equals("13")){           		
                        // �ظ�ͼ����Ϣ
                        NewsMessage newsMessage = new NewsMessage();
                        newsMessage.setToUserName(fromUserName);
                        newsMessage.setFromUserName(toUserName);
                        newsMessage.setCreateTime(new Date().getTime());
                        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                        Article article = new Article();
                        article.setTitle("�ż���ȥ�Ķ�ح��������Ӫ��Ӫ����");
                        article.setDescription("�������� 2017�����ľ�������Ӫ���켯��� ������ഺ����ɫ�ľ�Ӫ�ﱼ�ܰɣ�");
                        article.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/FepiawovpW9miaLzBlGgjtBtbMP2Af484AfWTtxIpRrLZtib7u0gHoTwocHxfFMLgibkEb5zUI28UoQ49PySBN3VGg/0?wx_fmt=jpeg");
                        article.setUrl("http://mp.weixin.qq.com/s?__biz=MzIxMjgxNjcyNg==&mid=100000093&idx=1&sn=4029a17482fbdc054b9666464f2dc2f4&chksm=1741076420368e72f2f35266e554089ceaba4e33fe770e5e7a77c1b30aaed485bc8348f6a536#rd");
                        Article article1 = new Article();
                        article1.setTitle("�ƶ����ŵ���5��4ҹ��ѧ����Ӫ");
                        article1.setDescription("������顢������·�����ٺ�����һ����һ������Ӫ�����Ļ������������óɳ��ḻ����ѧ������Ӫ�γ�����Χ���ص��Ļ���������ɫ�羰����Ԣ�����ֳ�Ϊһ����ʵ�ֵĽ���Ŀ�ġ�");
                        article1.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/FepiawovpW9m7WAodIDxGnWBFn8dyrqyBFhAZn7lic3Gn6SeAsm3xQ9314RT74KcD4hbX3rWfQoibEat4BmTJNO8A/0?wx_fmt=jpeg");
                        article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzIxMjgxNjcyNg==&mid=100000093&idx=2&sn=cc75234c2a6215f8f58895131543cfcd&chksm=1741076420368e7277313ee38a4c94ff2cc82da32e838d432097a7113c838236deef48514008#rd");
                        Article article2 = new Article();
                        article2.setTitle("�ɳ�ϵ��֮��Ȼ����5��Ӫ  -----  ��Ȼ��Ⱥ�����");
                        article2.setDescription("�ɳ�ϵ��֮��Ȼ����5��Ӫ----��Ȼ��Ⱥ����ǣ�\n��������ǽ���������ս��̽�ա������ø����������ж����ɳ������ף�\n��������ǹ�ͬѰ�����ڵ�ǿ���������ع����š��¸ҡ����⣡");
                        article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/FepiawovpW9m7WAodIDxGnWBFn8dyrqyBJ6iandOibmmyahlkNAgZCKXeScK5iclU13YVWckZjWGiba8OsJ5zbBu4pw/0?wx_fmt=jpeg");
                        article2.setUrl("http://mp.weixin.qq.com/s?__biz=MzIxMjgxNjcyNg==&mid=100000093&idx=3&sn=3a4879ad2b0616bfd63546e8c6b7115d&chksm=1741076420368e724b93a36d44e00c35faaebfbe3b028ed774884ecea5156b4289dda5854f5b#rd");
                        List<Article> articles = new ArrayList<Article>();
                        articles.add(article);
                        articles.add(article1);
                        articles.add(article2);
                		newsMessage.setArticles(articles);
                		newsMessage.setArticleCount(3);
                		respXml = MessageUtil.messageToXml(newsMessage);
                		return respXml;
                	}
                	
                	if(eventKey!=null&&eventKey.equals("35")){
                		respContent="�ظ�����1��������Ƹ\r\n\r\n�ظ�����2�����ҵ��\r\n\r\n�ظ�����3����ϵ��ַ\r\n\r\n�ظ�����4�����ļ��\r\n\r\n�ظ�����5�����Ƹ�����Ϣ";
                	}
                }
            }
            // �����ı���Ϣ������
            textMessage.setContent(respContent);
            // ���ı���Ϣ����ת����xml
            respXml = MessageUtil.messageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    
	}


	public ISysUsersDAO getSysUsersDAO() {
		return sysUsersDAO;
	}


	public void setSysUsersDAO(ISysUsersDAO sysUsersDAO) {
		this.sysUsersDAO = sysUsersDAO;
	}

}
