package com.weixin.message.req;

/**
* ����: TextMessage </br>
* ����: ������Ϣ֮�ı���Ϣ </br>
* ������Ա�� wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */

public class TextMessage extends BaseMessage {

    // ��Ϣ����
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
