package com.weixin.message.resp;

/**
* ����: ImageMessage </br>
* ����: ͼƬ��Ϣ</br>
* ������Ա��wulm </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class ImageMessage extends BaseMessage {
    
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}