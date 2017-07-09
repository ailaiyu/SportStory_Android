package cn.sportstory.android.api.request;

/**
 * Created by Tamas on 2017/7/6.
 */

public class NearbyRequest {
    private double lat;
    private double lon;
    private long start;
    private int num;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
