package com.weixin.message.req;

/**
* ����: VoiceMessage </br>
* ����: ������Ϣ֮������Ϣ </br>
* ������Ա�� wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class VoiceMessage extends BaseMessage {

    // ý��ID
    private String MediaId;
    // ������ʽ
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
