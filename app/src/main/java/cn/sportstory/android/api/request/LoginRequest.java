package cn.sportstory.android.api.request;

/**
 * Created by Tamas on 2017/7/13.
 */
public class LoginRequest {
    public static final int TYPE_PHONE=1;
    public static final int TYPE_EMAIL=2;

    private String phone;
    private String email;
    private int accountType;

    private String password;

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

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
