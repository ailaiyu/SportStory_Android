package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 发送短信验证码
 */
public class SendVCodeBean extends CommonBean {
    private String phone;
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
