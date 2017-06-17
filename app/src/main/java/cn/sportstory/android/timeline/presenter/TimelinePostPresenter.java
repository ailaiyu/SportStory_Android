package cn.sportstory.android.timeline.presenter;

import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.timeline.contract.TimelinePostContract;
import cn.sportstory.android.timeline.model.postTimeline.TimelinePost;
import cn.sportstory.android.timeline.model.postTimeline.TimelinePostModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelinePostPresenter extends TimelinePostContract.Presenter {

    TimelineBean bean;
    TimelinePostModel model;

    public TimelinePostPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {
        model.postTimeline(bean, new Callback<TimelineBean>() {
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
        model = new TimelinePost(this);
    }
}
