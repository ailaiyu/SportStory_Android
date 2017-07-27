package cn.sportstory.android.api;

import cn.sportstory.android.api.request.FollowRequest;
import cn.sportstory.android.entity.GenericResult;
import cn.sportstory.android.entity.GenericResultWithList;
import cn.sportstory.android.entity.SimpleUserInfo;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Tamas on 2017/7/27.
 */

public interface FollowApi {

    @PUT("follow")
    Flowable<GenericResult> follow(@Header("token")String token,@Body FollowRequest followRequest);


    @GET("follow/following/{page}")
    Flowable<GenericResultWithList<SimpleUserInfo>> getFollowingList(@Header("token")String token, @Path("page")int page);

    @GET("follow/follower/{page}")
    Flowable<GenericResultWithList<SimpleUserInfo>> getFollowerList(@Header("token")String token, @Path("page")int page);

}
