package cn.sportstory.android.timeline.model.getTimeline;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.common.bean.TimelineGetBean;
import cn.sportstory.android.timeline.contract.TimelineGetContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class TimelineGet extends TimelineGetModel {

    public TimelineGet(TimelineGetContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getTimeline(TimelineGetBean bean, Callback<TimelineGetBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("type", bean.getType());
        map.put("uid", bean.getUid());
        Call<TimelineGetBean> repos = service.getTimeline(map);
        repos.enqueue(callback);

    }
}
