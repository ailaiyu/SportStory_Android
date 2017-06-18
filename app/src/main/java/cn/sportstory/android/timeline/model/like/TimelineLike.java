package cn.sportstory.android.timeline.model.like;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.common.bean.TimelineLikeBean;
import cn.sportstory.android.timeline.contract.TimelineLikeContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelineLike extends TimelineLikeModel {
    public TimelineLike(TimelineLikeContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void like(TimelineLikeBean bean, Callback<TimelineLikeBean> callback) {
        Call<TimelineLikeBean> repos = service.timelineLike(bean);
        repos.enqueue(callback);
    }
}
