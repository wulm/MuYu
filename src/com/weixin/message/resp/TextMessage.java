package com.weixin.message.resp;

/**
* ����: TextMessage </br>
* ����: �ı���Ϣ </br>
* ������Ա��wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class TextMessage extends BaseMessage {
    // �ظ�����Ϣ����
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}