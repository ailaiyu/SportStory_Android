package cn.sportstory.android.timeline.model.delTimeline;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.TimelineBean;
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
        Call<TimelineBean> repos = service.delTimeline(bean);
        repos.enqueue(callback);

    }
}
