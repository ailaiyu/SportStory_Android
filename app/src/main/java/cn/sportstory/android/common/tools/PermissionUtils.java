package cn.sportstory.android.common.tools;

import android.Manifest;
import android.content.Context;
import android.content.SyncRequest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/6.
 */

public class PermissionUtils {
    /**
     * 定位权限
     */
    public static final String REQUEST_ACCESS_LOCATION = android.Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final int REQUEST_CODE_ACCESS_LOCATION = 101;

    /**
     * 读取联系人权限
     */
    public static final String REQUEST_READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final int REQUEST_CODE_READ_CONTACTS = 102;

    /**
     * 相机权限
     */
    public static final String REQUEST_CAMERA = Manifest.permission.CAMERA;
    public static final int REQUEST_CODE_CAMERA = 103;

    /**
     * 根据请求code获取响应的请求说明
     * @param context
     * @param requestCode
     * @return
     */
    public static String GetExplanationByRequestCode(Context context, int requestCode){
        String explanation = "";
        switch (requestCode){
            case REQUEST_CODE_ACCESS_LOCATION:
                explanation = context.getString(R.string.request_explanation_access_location);
                break;
            case REQUEST_CODE_READ_CONTACTS:
                explanation = context.getString(R.string.request_explanation_read_contacts);
                break;
//            case
        }
        return explanation;
    }
}
