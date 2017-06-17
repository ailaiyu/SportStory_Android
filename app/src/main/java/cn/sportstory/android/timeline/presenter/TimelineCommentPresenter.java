package cn.sportstory.android.timeline.presenter;

import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.TimelineCommentBean;
import cn.sportstory.android.timeline.contract.TimelineCommentContract;
import cn.sportstory.android.timeline.model.comment.TimelineComment;
import cn.sportstory.android.timeline.model.comment.TimelineCommentModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelineCommentPresenter extends TimelineCommentContract.Presenter {

    private TimelineCommentBean bean;
    private TimelineCommentContract.View view;
    private TimelineCommentModel model;

    public TimelineCommentPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {

        model.comment(bean, new Callback<TimelineCommentBean>() {
            @Override
            public void onResponse(Call<TimelineCommentBean> call, Response<TimelineCommentBean> response) {

            }

            @Override
            public void onFailure(Call<TimelineCommentBean> call, Throwable t) {
                view.showNetDisconnect();

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean) {
        this.bean = (TimelineCommentBean)bean;
        model = new TimelineComment(this);
    }
}
