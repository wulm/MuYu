package com.weixin.pojo;

/**
* ����: WeixinOauth2Token </br>
* ����:  ��ҳ��Ȩ��Ϣ  </br>
* ������Ա�� wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class WeixinOauth2Token {
    // ��ҳ��Ȩ�ӿڵ���ƾ֤
    private String accessToken;
    // ƾ֤��Чʱ��
    private int expiresIn;
    // ����ˢ��ƾ֤
    private String refreshToken;
    // �û���ʶ
    private String openId;
    // �û���Ȩ������
    private String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}