package com.weixin.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.pojo.Token;
import com.weixin.task.WeixinGetTokenTimerTask;
import com.weixin.util.WeixinSignUtil;
import com.weixin.util.WeixinUtil;

/**
* ����: MenuManager </br>
* ������ com.souvc.weixin.main
* ����:�˵��������� </br>
* ������Ա�� liuhf </br>
* ����ʱ�䣺  2015-12-1 </br>
* �����汾��V1.0  </br>
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void createMenu() {
    	
    	System.out.println("��̬�����˵�");
    	
        // �������û�Ψһƾ֤
        String appId = WeixinSignUtil.AppID;
        // �������û�Ψһƾ֤��Կ
        String appSecret = WeixinSignUtil.AppSecret;

        // ���ýӿڻ�ȡaccess_token
        Token accessToken = WeixinGetTokenTimerTask.token;

        if (null != accessToken) {
            // ���ýӿڴ����˵�
            int result = WeixinUtil.createMenu(getMenu(), accessToken.getAccessToken());

            // �жϲ˵��������
            if (0 == result){
                log.info("�˵������ɹ���");
                System.out.println("�˵������ɹ���");
            }
            else{
                log.info("�˵�����ʧ�ܣ������룺" + result);
                System.out.println("�˵�����ʧ�ܣ������룺"+result);
            }
        }
    }

    /**
     * ��װ�˵�����
     * 
     * @return
     */
    private static Menu getMenu() {
    	String baseUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=GOTOURL&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
    	
        CommonButton btn11 = new CommonButton();
        btn11.setName("У�ѻ�");
        btn11.setType("view");
        btn11.setUrl((baseUrl.replace("APPID",WeixinSignUtil.AppID)).replace("GOTOURL", "http://mingxin.imwork.net/MX_System/activitiesPublicity!getActivitiesPublicityList.action?type=1"));

        CommonButton btn12 = new CommonButton();
        btn12.setName("��ҵ��");
        btn12.setType("view");
        btn12.setUrl((baseUrl.replace("APPID",WeixinSignUtil.AppID)).replace("GOTOURL", "http://mingxin.imwork.net/MX_System/activitiesPublicity!getActivitiesPublicityList.action?type=2"));

        CommonButton btn13 = new CommonButton();
        btn13.setName("������չ");
        btn13.setType("view");
        btn13.setUrl((baseUrl.replace("APPID",WeixinSignUtil.AppID)).replace("GOTOURL", "http://mingxin.imwork.net/MX_System/activitiesPublicity!getActivitiesPublicityList.action?type=3"));

        CommonButton btn14 = new CommonButton();
        btn14.setName("���ӻ");
        btn14.setType("view");
        btn14.setUrl((baseUrl.replace("APPID",WeixinSignUtil.AppID)).replace("GOTOURL", "http://mingxin.imwork.net/MX_System/activitiesPublicity!getActivitiesPublicityList.action?type=4"));
        
        CommonButton btn15 = new CommonButton();
        btn15.setName("��Ҫ����");
        btn15.setType("click");
        btn15.setKey("15");

        CommonButton btn21 = new CommonButton();
        btn21.setName("У԰ʱ��");
        btn21.setType("view");
        btn21.setUrl("http://mingxin.imwork.net/MX_System/weixin!getSchoolNews.action");
        //btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx34c7cde93a1c5c40&redirect_uri=http://mingxin.imwork.net/MX_System/weixin!getWebAccessToken.action&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");

        CommonButton btn22 = new CommonButton();
        btn22.setName("���ʱ��");
        btn22.setType("view");
        btn22.setUrl("http://d1a7069951.iask.in/MX_System/weixin!getCountryNews.action");
        
        CommonButton btn31 = new CommonButton();
        btn31.setName("������ѵ");   
        btn31.setType("view");   
        btn31.setUrl("http://d1a7069951.iask.in/MX_System/weixin!getNotMyUser.action");

        CommonButton btn32 = new CommonButton();
        btn32.setName("����Ͷ��");
        btn32.setType("view");     
        btn32.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb235c46c4c2740a9&redirect_uri=http://d1a7069951.iask.in/MX_System/weixin!loadAddNews.action&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
        ///btn32.setUrl("http://d1a7069951.iask.in/MX_System/weixin!loadAddNews.action");     
        
        CommonButton btn33 = new CommonButton();
        btn33.setName("У԰����");
        btn33.setType("click");
        btn33.setKey("33");

        CommonButton btn34 = new CommonButton();
        btn34.setName("�ҵĻ���");
        btn34.setType("click");
        btn34.setKey("34");
        
        CommonButton btn35 = new CommonButton();
        btn35.setName("��������");
        btn35.setType("click");
        btn35.setKey("35");
        
        /**
         * ΢�ţ�  mainBtn1,mainBtn2,mainBtn3�ײ�������һ���˵���
         */
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("���Ļ");
        //һ������4���Ӳ˵�
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14,btn15 });

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("����ʱ��");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22 });

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("��������");
        mainBtn3.setSub_button(new CommonButton[] { btn31,btn32, btn33,btn34,btn35 });

        /**
         * ��װ�����˵�
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}