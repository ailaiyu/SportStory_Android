package cn.sportstory.sportstory.common.bean;

import java.util.List;

/**
 * Created by aaron on 2017/4/9.
 * 附近的人列表
 * 我认为还要加入一个字段：搜索分页始终位置 如搜索第20个到第40个 不可能一下把所有结果展示出来
 */
public class NeigborListBean extends CommonBean {
    private Double longitude;       //经度
    private Double latitude;        //纬度
    private int gender;             //性别
    private int ageFrom;            //最小年龄
    private int ageTo;              //最大年龄
    private int sportType;
    private int sportLevel;
    private List<NeigborInfoBean> neigborInfoList;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public int getSportType() {
        return sportType;
    }

    public void setSportType(int sportType) {
        this.sportType = sportType;
    }

    public int getSportLevel() {
        return sportLevel;
    }

    public void setSportLevel(int sportLevel) {
        this.sportLevel = sportLevel;
    }

    public List<NeigborInfoBean> getNeigborInfoList() {
        return neigborInfoList;
    }

    public void setNeigborInfoList(List<NeigborInfoBean> neigborInfoList) {
        this.neigborInfoList = neigborInfoList;
    }
}
