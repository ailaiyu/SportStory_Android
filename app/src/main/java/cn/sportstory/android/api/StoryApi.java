package cn.sportstory.android.api;

import cn.sportstory.android.constants.TestApiUrl;
import cn.sportstory.android.constants.UrlConstants;
import cn.sportstory.android.entity.GernericResultWithData;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.entity.TestResult;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tamas on 2017/7/9.
         */

public interface StoryApi {
    @GET(TestApiUrl.TIME_LINE_2)
    Flowable<GernericResultWithData<Story>> getTimeLine();
    @GET(TestApiUrl.TIME_LINE)
    Flowable<GernericResultWithData<Story>> getTimeLinePage2();
}
