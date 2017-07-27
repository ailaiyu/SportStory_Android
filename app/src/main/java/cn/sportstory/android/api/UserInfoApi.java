package cn.sportstory.android.api;

import cn.sportstory.android.api.request.SportInfoRequest;
import cn.sportstory.android.api.request.UserAreaRequest;
import cn.sportstory.android.entity.GenericResult;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.SimpleUserInfo;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;

/**
 * Created by Tamas on 2017/7/27.
 */

public interface UserInfoApi {

    @PUT("userinfo/area")
    Flowable<GenericResult> updateUserArea(@Header("token")String token,@Body UserAreaRequest areaRequest);

    @PUT("userinfo/sport")
    Flowable<GenericResult> updateUserSport(@Header("token")String token,@Body SportInfoRequest sportInfoRequest);

    @GET("userinfo/brefinfo")
    Flowable<GenericResultWithData<SimpleUserInfo>> getUserBrefInfo(@Header("token")String token);

    @PUT("userinfo/avatar")
    GenericResult updateAvatar(@Header("token")String token,@Field("avatarUrl") String avatarUrl);

    @PUT("userinfo/background")
    GenericResult updateBackground(@Header("token")String token,@Field("backgroundUrl")String backgroundUrl);


}
