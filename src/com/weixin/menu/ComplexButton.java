package com.weixin.menu;

/**
* ����: ComplexButton </br>
* ������ com.weixin.menu
* ����: ���˵��� :�����ж����˵����һ���˵�������˵�������ж������ԣ�name��sub_button����sub_button����һ���Ӳ˵������� </br>
* ������Ա�� wulm  </br>
* ����ʱ�䣺  2017.6.2 </br>
* �����汾��V1.0  </br>
 */
public class ComplexButton extends Button {
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
