package cn.sportstory.android.entity;


/**
 * Created by Tamas on 2017/7/23.
 */
public class SimpleUserInfoWithLocation extends SimpleUserInfo {
    private double lat;
    private double lng;
    private long lastLocationDate;


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getLastLocationDate() {
        return lastLocationDate;
    }

    public void setLastLocationDate(long lastLocationDate) {
        this.lastLocationDate = lastLocationDate;
    }
}
