package cn.sportstory.android.nearby.bean;

import cn.sportstory.android.common.bean.UserSportBean;

/**
 * Created by aaron on 2017/5/16.
 */

public class NearbyBean {
    private String userId;
    private String avatarPath;
    private String nickname;
    private UserSportBean[] sports;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserSportBean[] getSports() {
        return sports;
    }

    public void setSports(UserSportBean[] sports) {
        this.sports = sports;
    }
}
