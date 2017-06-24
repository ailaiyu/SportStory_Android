package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/6/22.
 */

public class OSTokenBean extends CommonBean {
    private String type;
    private String token;

    public static final String FILE_TYPE_AVATAR = "avatar";
    public static final String FILE_TYPE_BACKGROUND = "background";


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
