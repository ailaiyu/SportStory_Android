package cn.sportstory.android.account.model.follow;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UserFollowContract;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserFollowerBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public class FollowerModelImpl extends FollowModel {
    public FollowerModelImpl(UserFollowContract.Presenter presenter) {
        super(presenter);
    }


    public void getFollowers(UserFollowerBean bean, Callback<UserBean[]> callback){
        Map<String, String> map = new HashMap<>();
        map.put("f_id", bean.getF_id());
        map.put("start", bean.getStart());
        map.put("num", bean.getNum());
        Call<UserBean[]> repos = service.getFollowers(map);
        repos.enqueue(callback);
    }

    public void removeFollower(UserFollowerBean bean, Callback<UserFollowerBean> callback) {

    }
}
