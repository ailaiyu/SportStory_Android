package cn.sportstory.android.timeline.model.comment;

import android.content.Context;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.TimelineCommentBean;
import cn.sportstory.android.timeline.contract.TimelineCommentContract;
import cn.sportstory.android.timeline.contract.TimelineLikeContract;
import cn.sportstory.android.timeline.model.like.TimelineLikeModel;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelineComment extends TimelineCommentModel {
    public TimelineComment(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void comment(TimelineCommentBean bean, Callback<TimelineCommentBean> callback) {
        Call<TimelineCommentBean> repos = service.timelineComment(bean);
        repos.enqueue(callback);
    }
}
