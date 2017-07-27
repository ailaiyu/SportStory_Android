package cn.sportstory.android.entity;

/**
 * Created by Tamas on 2017/7/19.
 */
public class SimpleUserInfo {
    private long userId;
    private String nickname;
    private String avatarUrl;
    private String slogan;
    private String gender;
    private String province;
    private String city;
    private String district;
    private int sportId1;
    private int sportId2;
    private int sportId3;
    private int sportLevel1;
    private int sportLevel2;
    private int sportLevel3;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getSportId1() {
        return sportId1;
    }

    public void setSportId1(int sportId1) {
        this.sportId1 = sportId1;
    }

    public int getSportId2() {
        return sportId2;
    }

    public void setSportId2(int sportId2) {
        this.sportId2 = sportId2;
    }

    public int getSportId3() {
        return sportId3;
    }

    public void setSportId3(int sportId3) {
        this.sportId3 = sportId3;
    }

    public int getSportLevel1() {
        return sportLevel1;
    }

    public void setSportLevel1(int sportLevel1) {
        this.sportLevel1 = sportLevel1;
    }

    public int getSportLevel2() {
        return sportLevel2;
    }

    public void setSportLevel2(int sportLevel2) {
        this.sportLevel2 = sportLevel2;
    }

    public int getSportLevel3() {
        return sportLevel3;
    }

    public void setSportLevel3(int sportLevel3) {
        this.sportLevel3 = sportLevel3;
    }
}
