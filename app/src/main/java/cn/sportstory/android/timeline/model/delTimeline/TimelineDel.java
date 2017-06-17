package cn.sportstory.android.timeline.model.delTimeline;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.timeline.contract.TimelineDelContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelineDel extends TimelineDelModel {

    public TimelineDel(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void delTimeline(TimelineBean bean, Callback<TimelineBean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("t_id", bean.getT_id());
        Call<TimelineBean> repos = service.delTimeline(map);
        repos.enqueue(callback);

    }
}
