package cn.sportstory.android.api.request;

/**
 * Created by Tamas on 2017/7/23.
 */
public class LocationRequest {
    private double lat;
    private double lng;

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
}
