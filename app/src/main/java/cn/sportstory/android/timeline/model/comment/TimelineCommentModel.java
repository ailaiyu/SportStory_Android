package cn.sportstory.android.timeline.model.comment;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.TimelineCommentBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public abstract class TimelineCommentModel extends BaseModel {
    public TimelineCommentModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void comment(TimelineCommentBean bean, Callback<TimelineCommentBean> callback);
}
