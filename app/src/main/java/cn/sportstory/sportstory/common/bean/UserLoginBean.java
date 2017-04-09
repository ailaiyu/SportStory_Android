package cn.sportstory.sportstory.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 用户登录 返回用户token 我认为还需要加一个返回字段：uid
 */
public class UserLoginBean extends CommonBean {
    private String phone;
    private String password;
    private String item;        //token

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
