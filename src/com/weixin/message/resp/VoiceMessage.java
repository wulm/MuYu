package com.weixin.message.resp;

/**
* ����: VoiceMessage </br>
* ����: ������Ϣ</br>
* ������Ա�� wulm	 </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class VoiceMessage extends BaseMessage {
    // ����
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}