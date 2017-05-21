package cn.sportstory.android.timeline.model;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.bean.TimelineFollowBean;
import cn.sportstory.android.timeline.contract.TimelineFollowContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class TimelineFollow extends TimelineFollowModel {

    public TimelineFollow(TimelineFollowContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    void getTimeline(TimelineFollowBean bean, Callback<TimelineFollowBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("type", bean.getType());
        map.put("uid", bean.getUid());
        Call<TimelineFollowBean> repos = service.getTimeline(map);
        repos.enqueue(callback);

    }
}
