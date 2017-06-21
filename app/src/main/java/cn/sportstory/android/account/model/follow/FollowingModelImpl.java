package cn.sportstory.android.account.model.follow;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UserFollowContract;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserFollowingBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/28.
 */

public class FollowingModelImpl extends FollowModel {

    public FollowingModelImpl(BasePresenter presenter) {
        super(presenter);
    }

    public void getFollowing(UserFollowingBean bean, Callback<UserFollowingBean> callback){
        Call<UserFollowingBean> repos = service.getFollowing(bean);
        repos.enqueue(callback);

    }

    public void follow(UserFollowingBean bean, Callback<UserFollowingBean> callback){
        Call<UserFollowingBean> repos = service.userFollowing(bean);
        repos.enqueue(callback);
    }
}
