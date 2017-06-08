package cn.sportstory.android.common.tools;

import android.content.Context;
import android.os.Build;

/**
 * Created by aaron on 2017/6/6.
 */

public class PermissionHelper {

    /**
     * 检察权限
     * @param context
     * @param permissions
     */
    public static void checkPermission(Context context, String[] permissions){
        Context ctx = context.getApplicationContext();

    }

    /**
     * 申请权限
     * @param context
     * @param permissions
     */
    public static void requestPermissions(Context context, String[] permissions){
        Context ctx = context.getApplicationContext();

    }

    /**
     * 获取当前版本api号
     * @return api版本号
     */
    public static int getSystemApiVersion(){
        return Build.VERSION.SDK_INT;
    }

}
