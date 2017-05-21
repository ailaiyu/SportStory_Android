package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/5/21.
 */

public class QueryUserBean {

    private String distance;
    private String uid;
    private String gender;
    private String avatar;
    private String time;
    private String nickname;
    private UserSportBean[] sport;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserSportBean[] getSport() {
        return sport;
    }

    public void setSport(UserSportBean[] sport) {
        this.sport = sport;
    }
}
