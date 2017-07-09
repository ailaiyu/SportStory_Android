package cn.sportstory.android.timeline.model.postTimeline;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.TimelineBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public abstract class TimelinePostModel extends BaseModel {
    public TimelinePostModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void postTimeline(TimelineBean bean, Callback<TimelineBean> callback);
}
