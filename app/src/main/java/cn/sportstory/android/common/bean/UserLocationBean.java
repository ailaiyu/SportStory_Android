package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/5/6.
 */

public class UserLocationBean extends CommonBean {
    private String lat;
    private String lon;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
