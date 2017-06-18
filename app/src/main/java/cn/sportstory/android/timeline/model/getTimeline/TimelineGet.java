package cn.sportstory.android.timeline.model.getTimeline;

import android.content.Context;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.TimelineGetBean;
import cn.sportstory.android.timeline.contract.TimelineGetContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class TimelineGet extends TimelineGetModel {

    public TimelineGet(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void getTimeline(TimelineGetBean bean, Callback<TimelineGetBean> callback) {
        Call<TimelineGetBean> repos = service.getTimeline(bean);
        repos.enqueue(callback);

    }
}
