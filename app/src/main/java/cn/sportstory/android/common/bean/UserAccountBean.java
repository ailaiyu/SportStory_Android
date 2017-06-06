package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/6/6.
 */

public class UserAccountBean extends CommonBean {
    private String phone;
    private String email;
    private String code;
    private String password;
    private String type;

    public static final String CHANGE_PASSWORD_TYPE_PHONE = "phone";
    public static final String CHANGE_PASSWORD_TYPE_EMAIL = "email";

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
