package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 发送短信验证码
 */
public class SendVCodeBean extends CommonBean {
    private String phone;

    public String getItem() {
        return phone;
    }

    public void setItem(String phone) {
        this.phone = phone;
    }
}
