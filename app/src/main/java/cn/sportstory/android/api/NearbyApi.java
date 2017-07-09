package cn.sportstory.android.api;

import cn.sportstory.android.api.request.NearbyRequest;
import cn.sportstory.android.api.result.TestResult;
import cn.sportstory.android.constants.UrlConstants;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tamas on 2017/7/6.
 */

public interface NearbyApi {
    /**
     * 获取附近的人
     *
     * @param
     * @return
     */
    @GET(UrlConstants.USER_NEARBY)
    Flowable<TestResult> getUserNearby(@Query("lat")double lat,@Query("lon")double lon);
}
