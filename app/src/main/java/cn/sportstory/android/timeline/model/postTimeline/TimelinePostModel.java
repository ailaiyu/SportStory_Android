package cn.sportstory.android.timeline.model.postTimeline;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.timeline.contract.TimelinePostContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public abstract class TimelinePostModel extends BaseModel {
    private TimelinePostContract.Presenter presenter;

    public TimelinePostModel(TimelinePostContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void postTimeline(TimelineBean bean, Callback<TimelineBean> callback);
}
