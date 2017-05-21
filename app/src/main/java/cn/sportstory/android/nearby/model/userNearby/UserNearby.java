package cn.sportstory.android.nearby.model.userNearby;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.common.bean.UserNearbyBean;
import cn.sportstory.android.nearby.contract.UserNearbyContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserNearby extends UserNearbyModel {
    public UserNearby(UserNearbyContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getUserNearby(UserNearbyBean bean, Callback<UserNearbyBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("lat", bean.getLat());
        map.put("lon", bean.getLon());
        map.put("time", bean.getTime());
        map.put("start", bean.getStart());
        map.put("num", bean.getNum());
        Call<UserNearbyBean> repos = service.getUserNearby(map);
        repos.enqueue(callback);
    }
}
