package cn.sportstory.sportstory.common.bean;

import org.w3c.dom.ProcessingInstruction;

/**
 * Created by aaron on 2017/4/9.
 * 发送短信验证码
 */
public class SendVCodeBean extends CommonBean {
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
