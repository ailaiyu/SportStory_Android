package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 附近的人信息
 */
public class NeigborInfoBean {
    private String uid;
    private String headImageUrl;
    private String nickname;
    private UserSportTypeBean userSportType;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserSportTypeBean getUserSportType() {
        return userSportType;
    }

    public void setUserSportType(UserSportTypeBean userSportType) {
        this.userSportType = userSportType;
    }
}
