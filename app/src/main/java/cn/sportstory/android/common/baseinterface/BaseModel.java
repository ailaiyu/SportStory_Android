package cn.sportstory.android.common.baseinterface;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import cn.sportstory.android.SportStoryApp;
import cn.sportstory.android.account.tools.UserTokenHelper;
import cn.sportstory.android.common.bean.UserAccountBean;
import cn.sportstory.android.common.retrofitServiceInterface.SportStoryService;
import cn.sportstory.android.common.tools.Environment;
import cn.sportstory.android.constants.UrlConstants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aaron on 2017/5/19.
 */

public abstract class BaseModel {

    protected SportStoryService service;
    private static final int DEFAULT_CONNECT_TIME_OUT = 5;
    private static final int DEFAULT_WRITE_TIME_OUT = 5;
    private static final int DEFAULT_READ_TIME_OUT = 5;

    protected BaseModel(BasePresenter presenter) {
        final String token = UserTokenHelper.getToken(presenter.getContext());
        final String language = Environment.isZh(presenter.getContext()) ? "zh_CN" : "en_US";
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("token", token)
                                .addHeader("Accept-Language", language)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .client(client)
                .build();

        service = retrofit.create(SportStoryService.class);
    }


}
