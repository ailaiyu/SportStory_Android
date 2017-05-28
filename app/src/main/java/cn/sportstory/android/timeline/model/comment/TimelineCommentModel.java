package cn.sportstory.android.timeline.model.comment;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.common.bean.TimelineCommentBean;
import cn.sportstory.android.timeline.contract.TimelineCommentContract;
import cn.sportstory.android.timeline.contract.TimelineDelContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public abstract class TimelineCommentModel extends BaseModel {
    TimelineCommentContract.Presenter presenter;

    public TimelineCommentModel(TimelineCommentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void comment(TimelineCommentBean bean, Callback<TimelineCommentBean> callback);
}
