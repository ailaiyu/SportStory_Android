package cn.sportstory.android.timeline.presenter;


import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.TimelineFollowBean;
import cn.sportstory.android.timeline.contract.TimelineFollowContract;
import cn.sportstory.android.timeline.model.TimelineFollow;
import cn.sportstory.android.timeline.model.TimelineFollowModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/21.
 */

public class TimelineFollowPresenter extends TimelineFollowContract.Presenter {

    private TimelineFollowContract.View view;
    private TimelineFollowBean bean;
    private TimelineFollowModel model;

    @Override
    public void doTask() {
        model.getTimeline(bean, new Callback<TimelineFollowBean>() {
            @Override
            public void onResponse(Call<TimelineFollowBean> call, Response<TimelineFollowBean> response) {

            }

            @Override
            public void onFailure(Call<TimelineFollowBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean, BaseView view) {
        model = new TimelineFollow(this);
        this.view = (TimelineFollowContract.View)view;
        this.bean = new TimelineFollowBean();
    }
}
