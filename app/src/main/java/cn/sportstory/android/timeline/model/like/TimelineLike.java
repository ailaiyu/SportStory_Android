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

        Map<String, String> map = new HashMap<>();
        map.put("t_id", bean.getT_id());
        map.put("type", bean.getType());
        Call<TimelineLikeBean> repos = service.timelineLike(map);
        repos.enqueue(callback);
    }
}
