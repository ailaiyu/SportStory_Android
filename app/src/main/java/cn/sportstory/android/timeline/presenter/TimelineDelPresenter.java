package cn.sportstory.android.timeline.presenter;

import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.timeline.contract.TimelineDelContract;
import cn.sportstory.android.timeline.model.delTimeline.TimelineDel;
import cn.sportstory.android.timeline.model.delTimeline.TimelineDelModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelineDelPresenter extends TimelineDelContract.Presenter {
    private TimelineBean bean;
    private TimelineDelModel model;

    public TimelineDelPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {
        model.delTimeline(bean, new Callback<TimelineBean>() {
            @Override
            public void onResponse(Call<TimelineBean> call, Response<TimelineBean> response) {

            }

            @Override
            public void onFailure(Call<TimelineBean> call, Throwable t) {
                view.showNetDisconnect();

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean) {

        this.bean = (TimelineBean)bean;
        model = new TimelineDel(this);
    }
}
