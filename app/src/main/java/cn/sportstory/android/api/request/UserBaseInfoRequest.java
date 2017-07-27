package cn.sportstory.android.api.request;

/**
 * Created by Tamas on 2017/7/21.
 */
public class UserBaseInfoRequest {
    private int nickname;
    private String slogan;
    private String avatarUrl;
    private String backgroundUr;

    public int getNickname() {
        return nickname;
    }

    public void setNickname(int nickname) {
        this.nickname = nickname;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBackgroundUr() {
        return backgroundUr;
    }

    public void setBackgroundUr(String backgroundUr) {
        this.backgroundUr = backgroundUr;
    }
}
