package cn.sportstory.android.timeline.presenter;


import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.TimelineGetBean;
import cn.sportstory.android.timeline.contract.TimelineGetContract;
import cn.sportstory.android.timeline.model.getTimeline.TimelineGet;
import cn.sportstory.android.timeline.model.getTimeline.TimelineGetModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/21.
 */

public class TimelineGetPresenter extends TimelineGetContract.Presenter {

    private TimelineGetContract.View view;
    private TimelineGetBean bean;
    private TimelineGetModel model;

    @Override
    public void doTask() {
        model.getTimeline(bean, new Callback<TimelineGetBean>() {
            @Override
            public void onResponse(Call<TimelineGetBean> call, Response<TimelineGetBean> response) {

            }

            @Override
            public void onFailure(Call<TimelineGetBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean, BaseView view) {
        model = new TimelineGet(this);
        this.view = (TimelineGetContract.View)view;
        this.bean = new TimelineGetBean();
    }
}
