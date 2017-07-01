package cn.sportstory.android.common.tools;

import com.qiniu.android.http.ResponseInfo;

import org.json.JSONObject;

/**
 * Created by aaron on 2017/7/1.
 */

public abstract class QiNiuUploadCallback {
    public abstract void success(String key, ResponseInfo info, JSONObject response);
    public abstract void failed(String key, ResponseInfo info, JSONObject response);
}
