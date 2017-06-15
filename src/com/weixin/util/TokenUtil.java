package com.weixin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.weixin.pojo.Token;

/**
* ����: TokenUtil </br>
* ����: Token </br>
* ������Ա�� wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class TokenUtil {
	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);
	/**
     * ��ȡ�ӿڷ���ƾ֤
     * 
     * @param appid ƾ֤
     * @param appsecret ��Կ
     * @return
     */
    public static Token getToken(String appid, String appsecret) {
        Token token = null;
        String requestUrl = CommonUtil.token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        // ����GET�����ȡƾ֤
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                token = null;
                // ��ȡtokenʧ��
                log.error("��ȡtokenʧ�� errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return token;
    }
    
    
   
}