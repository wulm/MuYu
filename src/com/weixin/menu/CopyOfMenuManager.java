package com.weixin.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weixin.pojo.Token;
import com.weixin.task.WeixinGetTokenTimerTask;
import com.weixin.util.WeixinSignUtil;
import com.weixin.util.WeixinUtil;

/**
* 类名: MenuManager </br>
* 包名： com.souvc.weixin.main
* 描述:菜单管理器类 </br>
* 开发人员： liuhf </br>
* 创建时间：  2015-12-1 </br>
* 发布版本：V1.0  </br>
 */
public class CopyOfMenuManager {
    private static Logger log = LoggerFactory.getLogger(CopyOfMenuManager.class);

    public static void createMenu() {
    	
    	System.out.println("动态创建菜单");
    	
        // 第三方用户唯一凭证
        String appId = WeixinSignUtil.AppID;
        // 第三方用户唯一凭证密钥
        String appSecret = WeixinSignUtil.AppSecret;

        // 调用接口获取access_token
        Token accessToken = WeixinGetTokenTimerTask.token;

        if (null != accessToken) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), accessToken.getAccessToken());

            // 判断菜单创建结果
            if (0 == result){
                log.info("菜单创建成功！");
                System.out.println("菜单创建成功！");
            }
            else{
                log.info("菜单创建失败，错误码：" + result);
                System.out.println("菜单创建失败！错误码："+result);
            }
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("校友会");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("毕业季");
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn13 = new CommonButton();
        btn13.setName("素质拓展");
        btn13.setType("click");
        btn13.setKey("13");

        CommonButton btn14 = new CommonButton();
        btn14.setName("亲子活动");
        btn14.setType("click");
        btn14.setKey("14");

        CommonButton btn21 = new CommonButton();
        btn21.setName("校园时报");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("乡村时报");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn31 = new CommonButton();
        btn31.setName("校园站");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("教育培训");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("赛事项目");
        btn33.setType("click");
        btn33.setKey("33");

        CommonButton btn34 = new CommonButton();
        btn34.setName("鸣心招聘");
        btn34.setType("click");
        btn34.setKey("34");
        
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("鸣心活动");
        //一级下有4个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });

        
        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("鸣心时报");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22 });

        
        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("鸣心站点");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33,btn34 });

        
        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}