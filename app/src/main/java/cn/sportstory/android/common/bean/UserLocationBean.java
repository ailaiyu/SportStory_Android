package cn.sportstory.android.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaron on 2017/5/6.
 */

public class UserLocationBean extends CommonBean implements Parcelable {
    private double lat;         //经度
    private double lon;         //纬度
    private String city;        //城市
    private String address;     //地址
    private int locationType;   //定位结果来源, 如网络定位等
    private float accuracy;     //精度信息
    private String country;     //国家
    private String province;    //省
    private String district;    //城区
    private String street;      //街道
    private String streetNum;   //街道门牌号
    private String cityCode;    //城市编码
    private String adCode;      //地区编码
    private String aoiName;     //AOI信息， 这是什么鬼？？？
    private String buildingId;  //建筑物ID
    private String floor;       //所在楼层


    public static final Parcelable.Creator<UserLocationBean> CREATOR = new ClassLoaderCreator<UserLocationBean>() {
        @Override
        public UserLocationBean createFromParcel(Parcel source, ClassLoader loader) {
            return createFromParcel(source);
        }

        @Override
        public UserLocationBean createFromParcel(Parcel source) {
            UserLocationBean bean = new UserLocationBean();
            bean.setLat(source.readDouble());
            bean.setLon(source.readDouble());
            bean.setCity(source.readString());
            bean.setAddress(source.readString());
            bean.setLocationType(source.readInt());
            bean.setAccuracy(source.readFloat());
            bean.setCountry(source.readString());
            bean.setProvince(source.readString());
            bean.setDistrict(source.readString());
            bean.setStreet(source.readString());
            bean.setStreetNum(source.readString());
            bean.setCityCode(source.readString());
            bean.setAdCode(source.readString());
            bean.setAoiName(source.readString());
            bean.setBuildingId(source.readString());
            bean.setFloor(source.readString());

            return bean;
        }

        @Override
        public UserLocationBean[] newArray(int size) {
            return new UserLocationBean[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lon);
        dest.writeString(city);
        dest.writeString(address);
        dest.writeInt(locationType);
        dest.writeFloat(accuracy);
        dest.writeString(country);
        dest.writeString(province);
        dest.writeString(district);
        dest.writeString(street);
        dest.writeString(streetNum);
        dest.writeString(cityCode);
        dest.writeString(adCode);
        dest.writeString(aoiName);
        dest.writeString(buildingId);
        dest.writeString(floor);

    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getAoiName() {
        return aoiName;
    }

    public void setAoiName(String aoiName) {
        this.aoiName = aoiName;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
