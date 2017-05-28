package cn.sportstory.android.timeline.model.delTimeline;

import java.sql.Time;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.timeline.contract.TimelineDelContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public abstract class TimelineDelModel extends BaseModel {
    TimelineDelContract.Presenter presenter;

    public TimelineDelModel(TimelineDelContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void delTimeline(TimelineBean bean, Callback<TimelineBean> callback);
}
