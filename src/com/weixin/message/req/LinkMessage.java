package com.weixin.message.req;

/**
* ����: LinkMessage </br>
* ����: ������Ϣ֮������Ϣ </br>
* ������Ա�� wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class LinkMessage extends BaseMessage {

    // ��Ϣ����
    private String Title;
    // ��Ϣ����
    private String Description;
    // ��Ϣ����
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}