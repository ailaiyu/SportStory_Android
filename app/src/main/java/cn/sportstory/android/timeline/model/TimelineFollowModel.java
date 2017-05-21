package cn.sportstory.android.timeline.model;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.TimelineFollowBean;
import cn.sportstory.android.timeline.contract.TimelineFollowContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class TimelineFollowModel extends BaseModel {
    private TimelineFollowContract.Presenter presenter;

    public TimelineFollowModel(TimelineFollowContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void getTimeline(TimelineFollowBean bean, Callback<TimelineFollowBean> beanCallback);

}
