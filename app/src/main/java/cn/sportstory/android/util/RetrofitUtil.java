package cn.sportstory.android.util;


import junit.framework.Test;

import java.io.IOException;

import cn.sportstory.android.constants.TestApiUrl;
import cn.sportstory.android.constants.UrlConstants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tamas on 2016/11/1.
 */

public class RetrofitUtil {
    private static Retrofit sV2Retrofit;
    private static Retrofit sTestRetrofit;

    static {
        sV2Retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(genericClient())
                .build();
        sTestRetrofit=new Retrofit.Builder()
                .baseUrl(TestApiUrl.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(genericClient())
                .build();

    }
    private static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json; charset=UTF-8")
                                .addHeader("Accept-Encoding", "utf-8, deflate")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("token","cbe1715f7c7a4f5a9f7d8e88bbcf41ff")
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();

        return httpClient;
    }



    public static Retrofit getRetrofit(){
        return sV2Retrofit;
    }
    public static Retrofit getTestRetrofit(){
        return sTestRetrofit;
    }

}
