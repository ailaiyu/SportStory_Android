package cn.sportstory.android.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import cn.sportstory.android.common.bean.UserLocationBean;


/**
 * Created by aaron on 2017/4/26.
 * 后台定位服务器，在application中app进入前台开启，在退出前台后关闭
 */

public class LocationService extends Service {

    public AMapLocationClient client = null;
    public AMapLocationClientOption option = null;
    public static final int FIVE_MINUTES = 300000;
    public static final String ACTION_LOCATION_SUCCESS =
            "cn.sportstory.android.common.service.LocationService.LocationSuccess";
    public AMapLocationListener listener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null)
            {
                if (aMapLocation.getErrorCode() == 0)
                {
                    // TODO: 2017/5/1  定位成功
                    UserLocationBean bean = new UserLocationBean();
                    bean.setLocationType(aMapLocation.getLocationType());//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    bean.setLat(aMapLocation.getLatitude());//获取纬度
                    bean.setLon(aMapLocation.getLongitude());//获取经度
                    bean.setAccuracy(aMapLocation.getAccuracy());//获取精度信息
                    bean.setAddress(aMapLocation.getAddress());//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    bean.setCountry(aMapLocation.getCountry());//国家信息
                    bean.setProvince(aMapLocation.getProvince());//省信息
                    bean.setCity(aMapLocation.getCity());//城市信息
                    bean.setDistrict(aMapLocation.getDistrict());//城区信息
                    bean.setStreet(aMapLocation.getStreet());//街道信息
                    bean.setStreetNum(aMapLocation.getStreetNum());//街道门牌号信息
                    bean.setCityCode(aMapLocation.getCityCode());//城市编码
                    bean.setAdCode(aMapLocation.getAdCode());//地区编码
                    bean.setAoiName(aMapLocation.getAoiName());//获取当前定位点的AOI信息
                    bean.setBuildingId(aMapLocation.getBuildingId());//获取当前室内定位的建筑物Id
                    bean.setFloor(aMapLocation.getFloor());//获取当前室内定位的楼层

                    Intent intent = new Intent();
                    intent.setAction(ACTION_LOCATION_SUCCESS);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("location", bean);
                    intent.putExtras(bundle);
                    sendBroadcast(intent);
                }else {
                    // TODO: 2017/5/1 定位失败 
                }

            }else {
                // TODO: 2017/5/1  定位失败
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        client = new AMapLocationClient(getApplicationContext());
        client.setLocationListener(listener);
        option = new AMapLocationClientOption();
        //低功耗模式，只使用WIFI或基站定位
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //每五分钟定位一次
        option.setInterval(FIVE_MINUTES);
        option.setNeedAddress(true);
        //设置获取位置超时时间，如果这次定位超时，这次返回timeout， 下次将继续按照既定时间定位
        option.setHttpTimeOut(30000);
        client.setLocationOption(option);
        client.startLocation();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        client.stopLocation();
        client.onDestroy();
        client = null;
        listener = null;
    }


}
