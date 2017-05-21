package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserNearbyBean extends CommonBean {
    private String lat;
    private String lon;
    private String time;
    private String start;
    private String num;
    private QueryUserBean[] users;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public QueryUserBean[] getUsers() {
        return users;
    }

    public void setUsers(QueryUserBean[] users) {
        this.users = users;
    }
}
