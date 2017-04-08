package cn.sportstory.sportstory.common.retrofitServiceInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aaron on 2017/4/7.
 * 运动故事服务端的访问接口
 * 使用post方法访问
 */
public interface SportStoryService {

    /**
     * 发送短信验证码
     * @param item 手机号
     * @return
     */
    @FormUrlEncoded
    @POST("/vcode/send")
    Call<ResponseBody> sendVcode(
            @Field("item") String item
    );


}
