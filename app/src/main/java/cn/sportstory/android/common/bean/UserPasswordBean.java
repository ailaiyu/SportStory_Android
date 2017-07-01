package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/7/1.
 */

public class UserPasswordBean extends CommonBean {
    private String password;
    private String type;
    private String code;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
