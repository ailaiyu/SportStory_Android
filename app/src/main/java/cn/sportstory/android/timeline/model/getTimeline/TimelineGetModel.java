package cn.sportstory.android.timeline.model.getTimeline;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.TimelineGetBean;
import cn.sportstory.android.timeline.contract.TimelineGetContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class TimelineGetModel extends BaseModel {
    private TimelineGetContract.Presenter presenter;

    public TimelineGetModel(TimelineGetContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void getTimeline(TimelineGetBean bean, Callback<TimelineGetBean> beanCallback);

}
