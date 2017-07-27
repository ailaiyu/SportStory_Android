package cn.sportstory.android.api;

import cn.sportstory.android.api.request.LocationRequest;
import cn.sportstory.android.entity.GenericResult;
import cn.sportstory.android.entity.GenericResultWithList;
import cn.sportstory.android.entity.SimpleUserInfoWithLocation;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Tamas on 2017/7/27.
 */

public interface LocationApi {

    @PUT("location")
    Flowable<GenericResult> updateUserLocation(@Header("token")String token,@Body LocationRequest locationRequest);

    @GET("{lat}/{lng}/{page}")
    Flowable<GenericResultWithList<SimpleUserInfoWithLocation>>getNearbyUserList(@Header("token")String token,@Path("lat")double lat,@Path("lng")double lng,@Path("page")int page);
}
