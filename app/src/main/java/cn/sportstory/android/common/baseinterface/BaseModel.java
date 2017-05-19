package cn.sportstory.android.common.baseinterface;

import java.util.concurrent.TimeUnit;

import cn.sportstory.android.common.retrofitServiceInterface.SportStoryService;
import cn.sportstory.android.constants.UrlConstants;
import okhttp3.OkHttpClient;
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

    protected BaseModel() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlConstants.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create()).client(client).build();

        service = retrofit.create(SportStoryService.class);
    }
}
