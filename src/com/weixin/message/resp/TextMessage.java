package com.weixin.message.resp;

/**
* 类名: TextMessage </br>
* 描述: 文本消息 </br>
* 开发人员：wulm </br>
* 创建时间：  2017.6.2 </br>
* 发布版本：V1.0  </br>
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}