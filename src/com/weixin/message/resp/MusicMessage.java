package com.weixin.message.resp;

/**
* ����: MusicMessage </br>
* ����: ������Ϣ </br>
* ������Ա��wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class MusicMessage extends BaseMessage {
    // ����
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}