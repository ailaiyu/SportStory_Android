package cn.sportstory.android.timeline.presenter;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.TimelineLikeBean;
import cn.sportstory.android.timeline.contract.TimelineLikeContract;
import cn.sportstory.android.timeline.model.like.TimelineLike;
import cn.sportstory.android.timeline.model.like.TimelineLikeModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelineLikePresenter extends TimelineLikeContract.Presenter {

    private TimelineLikeBean bean;
    private TimelineLikeContract.View view;
    private TimelineLikeModel model;

    @Override
    public void doTask() {

        model.like(bean, new Callback<TimelineLikeBean>() {
            @Override
            public void onResponse(Call<TimelineLikeBean> call, Response<TimelineLikeBean> response) {

            }

            @Override
            public void onFailure(Call<TimelineLikeBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean, BaseView view) {

        this.bean = (TimelineLikeBean)bean;
        this.view = (TimelineLikeContract.View) view;
        model = new TimelineLike(this);
    }
}
