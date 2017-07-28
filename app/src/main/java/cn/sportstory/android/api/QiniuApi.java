package cn.sportstory.android.api;

import cn.sportstory.android.entity.GenericResultWithData;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Tamas on 2017/7/27.
 */

public interface QiniuApi {

    @GET("qiniu/avatar")
    Flowable<GenericResultWithData<String>> getAvatarToken(@Header("token")String token);

    @GET("qiniu/background")
    Flowable<GenericResultWithData<String>> getBackgroundToken(@Header("token")String token);

    @GET("qiniu/timeline")
    Flowable<GenericResultWithData<String>> getTimelineToken(@Header("token")String token);

}
