package com.weixin.menu;

/**
* ����: CommonButton </br>
* ������ com.weixin.menu
* ����: �Ӳ˵��� :û���Ӳ˵��Ĳ˵���п����Ƕ����˵��Ҳ�п����ǲ��������˵���һ���˵��� </br>
* ������Ա�� wulm  </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class CommonButton extends Button {
    
    private String type;
    private String key;
    private String url;
    private String appid;
    private String pagepath;
    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}