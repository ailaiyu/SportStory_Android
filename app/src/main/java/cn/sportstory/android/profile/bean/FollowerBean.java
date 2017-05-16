package cn.sportstory.android.profile.bean;

/**
 * Created by aaron on 2017/5/16.
 */

public class FollowerBean {
    private String mAvatarPath;
    private String userId;
    private String nickname;

    public String getmAvatarPath() {
        return mAvatarPath;
    }

    public void setmAvatarPath(String mAvatarPath) {
        this.mAvatarPath = mAvatarPath;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
