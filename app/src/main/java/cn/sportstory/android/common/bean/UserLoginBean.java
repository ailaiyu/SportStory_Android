package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 用户登录 返回用户token 我认为还需要加一个返回字段：uid
 */
public class UserLoginBean extends CommonBean {
    public static final String LOGIN_TYPE_PHONE = "phone";
    public static final String LOGIN_TYPE_EMAIL = "email";
    public static final String LOGIN_TYPE_PHONE_VCODE = "1";
    public static final String LOGIN_TYPE_PHONE_PASSWORD = "2";
    public static final String LOGIN_TYPE_EMAIL_VCODE = "3";
    public static final String LOGIN_TYPE_EMAIL_PASSWORD = "4";
    private String phone;
    private String password;
    private String email;
    private String code;
    private String is_perfect;
    private String province;
    private String city;
    private String weight;
    private String gender;
    private String is_valid;
    private String avatar;
    private String background;
    private String stature;
    private String nickname;
    private String login_type;
    private String loginType;
    private String f_id;

    public String getLogin_type() {
        return login_type;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }

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

    public String getIs_perfect() {
        return is_perfect;
    }

    public void setIs_perfect(String is_perfect) {
        this.is_perfect = is_perfect;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }
}
