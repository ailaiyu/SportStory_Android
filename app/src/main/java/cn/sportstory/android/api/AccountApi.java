package cn.sportstory.android.api;

import cn.sportstory.android.api.request.LoginRequest;
import cn.sportstory.android.entity.Account;
import cn.sportstory.android.entity.GenericResultWithData;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Tamas on 2017/7/27.
 */

public interface AccountApi {

    @POST("account/login")
    Flowable<GenericResultWithData<Account>> loginWithPhone(@Body LoginRequest loginRequest);

    @POST("account/login")
    Flowable<GenericResultWithData<Account>> getUserInfo(@Header("token")String token);


}
