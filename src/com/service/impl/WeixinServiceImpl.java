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

	private ISysUsersDAO sysUsersDAO;//依赖注入用户dao
	
	public String processRequest(HttpServletRequest request) {
		System.out.println("process");
		// TODO Auto-generated method stub
		System.out.println("微信用户发出请求");
		// xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
        	
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            
            // 发送方帐号openid
            String fromUserName = requestMap.get("FromUserName");
            //System.out.println("发送方账号："+fromUserName);
            
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            //System.out.println("开发者微信号："+toUserName);
            
            // 消息类型
            String msgType = requestMap.get("MsgType");
            
            //获取请求用户信息
            WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	String content=requestMap.get("Content");
            	if("1".equals(content)){
            		respContent = "请投放个人简历至mingxin2017@yahoo.com，我们将尽快与你联系，鸣心真诚期待你的加入！";
            	}else if("2".equals(content)){
            		respContent = "广告投放请联系18888888888，鸣心将诚挚与您合作！";
            	}else if("3".equals(content)){
            		respContent = "鸣心文化有限公司地址：古田县城东街道建设路8号，邮政编码352200";
            	}else{
            		respContent = "回复有误,感谢您对鸣心的关注！";
            	}
                
                //测试获取用户详细信息
//                WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);
//                System.out.println(wui.getNickname());
//                System.out.println(wui.getSex());
//                System.out.println(wui.getCity());
//                System.out.println(wui.getOpenId());
//                System.out.println(wui.getHeadImgUrl());
//                System.out.println(wui.getProvince());
                
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                respContent = "您发送的是小视频消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "终于等到你！！";
                    
                    //用户关注后，即可成为系统普通用户
                  //获取用户微信号详细信息
                    //WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);
                    System.out.println(wui.getNickname());
                    System.out.println(wui.getSex());
                    System.out.println(wui.getCity());
                    System.out.println(wui.getOpenId());
                    System.out.println(wui.getHeadImgUrl());
                    System.out.println(wui.getProvince());
                    
                    System.out.println("用户关注公众号，自动添加为系统普通用户");
                    
                    MxUsersData user=new MxUsersData();
                    user.setWeixinNikeName(wui.getNickname());
                    user.setWeixinOpenId(wui.getOpenId());
                    user.setWeixinHeadUrl(wui.getHeadImgUrl());
                    MxUsersData ur=sysUsersDAO.getUserByOpenId(wui.getOpenId());
                    if(ur==null){
                    	sysUsersDAO.addUser(user);
                        System.out.println("微信关注，用户添加成功");
                    }else if(ur.getUserState()==-1){
                    	ur.setUserState(0);
                    	sysUsersDAO.setUserState(ur);
                    }
                    
                    
                }
                // 取消关注
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                	//WeixinUserInfo wui=WeixinUtil.getUserInfo(WeixinGetTokenTimerTask.token.getAccessToken(), fromUserName);
                	MxUsersData ur=sysUsersDAO.getUserByOpenId(wui.getOpenId());
                	if(ur!=null){
                		ur.setUserState(-1);
                		sysUsersDAO.setUserState(ur);
                	}
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复,将数据库中用户状态设为-1
                }
                // 扫描带参数二维码
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                	respContent = "扫描了二维码！";
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    // TODO 处理上报地理位置事件
                	respContent = "上报地理位置！";
                }
                // 自定义菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                	respContent = "菜单点击事件！";
                	String eventKey=requestMap.get("EventKey");
                	System.out.println("eventKey值为"+ requestMap.get("EventKey"));
                	
                	//新闻投稿
                	if(eventKey.equals("32")){ 
                		//检验用户是否关注公众号
                        //测试获取用户详细信息
                        System.out.println(wui.getNickname());
                        System.out.println(wui.getSex());
                        System.out.println(wui.getCity());
                        System.out.println(wui.getOpenId());
                        System.out.println(wui.getHeadImgUrl());
                        System.out.println(wui.getProvince());
                        //校验用户
                        int isExistUser = sysUsersDAO.isExistUser(wui.getOpenId());
                        if(isExistUser == 0){
                        	//限制未关注返回图文  后期改成二维码图文
                            NewsMessage newsMessage = new NewsMessage();
                            newsMessage.setToUserName(fromUserName);
                            newsMessage.setFromUserName(toUserName);
                            newsMessage.setCreateTime(new Date().getTime());
                            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                            Article article = new Article();
                            article.setTitle("放假了去哪儿丨军事夏令营开营啦！");
                            article.setDescription("炎热七月 2017年鸣心军事夏令营吹响集结号 让你的青春在绿色的军营里奔跑吧！");
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
                        //校验通过跳转到新闻填报界面
                        //校验失败提示关注公众号后再进行操作
                	}
                	//素质拓展
                	if(eventKey.equals("13")){           		
                        // 回复图文消息
                        NewsMessage newsMessage = new NewsMessage();
                        newsMessage.setToUserName(fromUserName);
                        newsMessage.setFromUserName(toUserName);
                        newsMessage.setCreateTime(new Date().getTime());
                        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                        Article article = new Article();
                        article.setTitle("放假了去哪儿丨军事夏令营开营啦！");
                        article.setDescription("炎热七月 2017年鸣心军事夏令营吹响集结号 让你的青春在绿色的军营里奔跑吧！");
                        article.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/FepiawovpW9miaLzBlGgjtBtbMP2Af484AfWTtxIpRrLZtib7u0gHoTwocHxfFMLgibkEb5zUI28UoQ49PySBN3VGg/0?wx_fmt=jpeg");
                        article.setUrl("http://mp.weixin.qq.com/s?__biz=MzIxMjgxNjcyNg==&mid=100000093&idx=1&sn=4029a17482fbdc054b9666464f2dc2f4&chksm=1741076420368e72f2f35266e554089ceaba4e33fe770e5e7a77c1b30aaed485bc8348f6a536#rd");
                        Article article1 = new Article();
                        article1.setTitle("悠度厦门岛·5天4夜游学夏令营");
                        article1.setDescription("读万卷书、行万里路这个暑假和鸣心一起来一场夏令营。将文化浸润于人生让成长丰富于游学。夏令营课程内容围绕鹭岛文化和厦门特色风景，让寓教于乐成为一件可实现的教育目的。");
                        article1.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/FepiawovpW9m7WAodIDxGnWBFn8dyrqyBFhAZn7lic3Gn6SeAsm3xQ9314RT74KcD4hbX3rWfQoibEat4BmTJNO8A/0?wx_fmt=jpeg");
                        article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzIxMjgxNjcyNg==&mid=100000093&idx=2&sn=cc75234c2a6215f8f58895131543cfcd&chksm=1741076420368e7277313ee38a4c94ff2cc82da32e838d432097a7113c838236deef48514008#rd");
                        Article article2 = new Article();
                        article2.setTitle("成长系列之自然户外5天营  -----  自然族群历奇记");
                        article2.setDescription("成长系列之自然户外5天营----自然族群历奇记；\n在这里，我们将经历“挑战、探险”，懂得感悟人生，感恩陪伴成长的至亲！\n在这里，我们共同寻找内在的强大能量，回归自信、勇敢、阳光！");
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
                		respContent="回复数字1：鸣心招聘\r\n\r\n回复数字2：广告业务\r\n\r\n回复数字3：联系地址\r\n\r\n回复数字4：鸣心简介\r\n\r\n回复数字5：完善个人信息";
                	}
                }
            }
            // 设置文本消息的内容
            textMessage.setContent(respContent);
            // 将文本消息对象转换成xml
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
