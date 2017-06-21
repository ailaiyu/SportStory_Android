package cn.sportstory.android.account.model.follow;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UserFollowContract;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserFollowerBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public class FollowerModelImpl extends FollowModel {

    public FollowerModelImpl(BasePresenter presenter) {
        super(presenter);
    }

    public void getFollowers(UserFollowerBean bean, Callback<UserFollowerBean> callback){

        Call<UserFollowerBean> repos = service.getFollowers(bean);
        repos.enqueue(callback);
    }

    public void removeFollower(UserFollowerBean bean, Callback<UserFollowerBean> callback) {

    }
}
