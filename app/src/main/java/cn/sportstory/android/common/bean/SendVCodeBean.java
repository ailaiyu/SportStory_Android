package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 发送短信验证码
 */
public class SendVCodeBean extends CommonBean {
    private String phone;
    private String code;
    private String type;
    public static final String SEND_TYPE_PHONE = "phone";
    public static final String SEND_TYPE_EMAIL = "emial";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
