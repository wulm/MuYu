package com.weixin.message.req;

/**
* ����: VideoMessage </br>
* ����: ������Ϣ֮��Ƶ��Ϣ </br>
* ������Ա�� wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class VideoMessage  extends BaseMessage{

    // ý��ID
    private String MediaId;
    // ������ʽ
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}