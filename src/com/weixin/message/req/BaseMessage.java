package com.weixin.message.req;

/**
* ����: BaseMessage </br>
* ����: ������Ϣ�Ļ��� </br>
* ������Ա��wulm</br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class BaseMessage {

    // ������΢�ź�
    private String ToUserName;
    // ���ͷ��ʺţ�һ��OpenID��
    private String FromUserName;
    // ��Ϣ����ʱ�� �����ͣ�
    private long CreateTime;
    // ��Ϣ���ͣ�text/image/location/link��
    private String MsgType;
    // ��Ϣid��64λ����
    private long MsgId;

    
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
