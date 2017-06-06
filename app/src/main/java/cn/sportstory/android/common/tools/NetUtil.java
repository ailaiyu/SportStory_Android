package cn.sportstory.android.common.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/6.
 */

public class NetUtil {

    public static final int IP_TYPE_NULL = 0;       //断开连接
    public static final int IP_TYPE_WIFI = 1;       //wifi
    public static final int IP_TYPE_MOBILE = 2;     //流量

    /**
     * 获取上网类型，wifi或移动数据
     * @return 网络类型
     */
    public static int getIpType(Context context) {

        context = context.getApplicationContext();
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return IP_TYPE_NULL;
        } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            return IP_TYPE_WIFI;
        } else
            return IP_TYPE_MOBILE;
    }

    /**
     * 检查是否联网
     * @param context
     * @return
     */
    public static boolean IsNetConnected(Context context) {
        context = context.getApplicationContext();
        if (IP_TYPE_NULL == getIpType(context)) {
            Toast.makeText(context, context.getString(R.string.net_time_out), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
