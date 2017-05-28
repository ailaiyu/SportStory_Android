package cn.sportstory.android.timeline.model.postTimeline;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.timeline.contract.TimelinePostContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelinePost extends TimelinePostModel {

    public TimelinePost(TimelinePostContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void postTimeline(TimelineBean bean, Callback<TimelineBean> callback) {
        Map<String, String> map = new HashMap<>();
        if (TextUtils.isEmpty(bean.getType()))
            return;
        else {
            map.put("type", bean.getType());
            if (bean.getType().equals(TimelinePostContract.Presenter.TIMELINE_TYPE_IMG)) {
                map.put("content", TextUtils.isEmpty(bean.getContent()) ? "" : bean.getContent());
                map.put("url", bean.getUrl());
            }else if (bean.getType().equals(TimelinePostContract.Presenter.TIMELINE_TYPE_TEXT)){
                map.put("content", bean.getContent());
                map.put("url", TextUtils.isEmpty(bean.getUrl()) ? "" : bean.getUrl());
            }
        }
        Call<TimelineBean> repos = service.postTimeline(map);
        repos.enqueue(callback);
    }
}
