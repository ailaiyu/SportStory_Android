package cn.sportstory.android.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;


/**
 * Created by aaron on 2017/4/26.
 * 后台定位服务器，在application中app进入前台开启，在退出前台后关闭
 */

public class LocationService extends Service {

    public AMapLocationClient client = null;
    public AMapLocationClientOption option = null;
    public static final int FIVE_MINUTES = 300000;
    public AMapLocationListener listener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null)
            {
                if (aMapLocation.getErrorCode() == 0)
                {
                    // TODO: 2017/5/1  定位成功
                    aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    aMapLocation.getLatitude();//获取纬度
                    aMapLocation.getLongitude();//获取经度
                    aMapLocation.getAccuracy();//获取精度信息
                    aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    aMapLocation.getCountry();//国家信息
                    aMapLocation.getProvince();//省信息
                    aMapLocation.getCity();//城市信息
                    aMapLocation.getDistrict();//城区信息
                    aMapLocation.getStreet();//街道信息
                    aMapLocation.getStreetNum();//街道门牌号信息
                    aMapLocation.getCityCode();//城市编码
                    aMapLocation.getAdCode();//地区编码
                    aMapLocation.getAoiName();//获取当前定位点的AOI信息
                    aMapLocation.getBuildingId();//获取当前室内定位的建筑物Id
                    aMapLocation.getFloor();//获取当前室内定位的楼层
                    Toast.makeText(LocationService.this, aMapLocation.getLatitude() + "" + aMapLocation.getLatitude() + " " + aMapLocation.getAddress(), Toast.LENGTH_LONG);
                    //aMapLocation.getGpsStatus();//获取GPS的当前状态
                    //获取定位时间
//                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    Date date = new Date(aMapLocation.getTime());
//                    df.format(date);
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
