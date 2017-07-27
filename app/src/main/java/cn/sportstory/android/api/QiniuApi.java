package cn.sportstory.android.api;

import cn.sportstory.android.entity.GenericResultWithData;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Tamas on 2017/7/27.
 */

public interface QiniuApi {

    @GET("qiniu/avatar")
    GenericResultWithData<String> getAvatarToken(@Header("token")String token);

    @GET("qiniu/background")
    GenericResultWithData<String> getBackgroundToken(@Header("token")String token);

    @GET("qiniu/timeline")
    GenericResultWithData<String> getTimelineToken(@Header("token")String token);

}
