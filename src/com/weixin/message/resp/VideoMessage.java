package com.weixin.message.resp;

/**
* ����: VideoMessage </br>
* ����: ��Ƶ��Ϣ </br>
* ������Ա�� wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class VideoMessage extends BaseMessage {
    // ��Ƶ
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
