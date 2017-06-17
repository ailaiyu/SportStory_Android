package cn.sportstory.android.account.presenter;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UserFollowContract;
import cn.sportstory.android.account.model.follow.FollowerModelImpl;
import cn.sportstory.android.account.model.follow.FollowingModelImpl;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserFollowerBean;
import cn.sportstory.android.common.bean.UserFollowingBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/28.
 */

public class UserFollowerPresenter extends UserFollowContract.Presenter {

    private UserFollowerBean followerBean;
    private UserFollowingBean followingBean;
    private FollowerModelImpl followerModel;
    private FollowingModelImpl followingModel;

    @Override
    public void doTask() {

    }

    //获取粉丝列表
    @Override
    public void getFollowers() {
        followerModel.getFollowers(followerBean, new Callback<UserBean[]>() {
            @Override
            public void onResponse(Call<UserBean[]> call, Response<UserBean[]> response) {

            }

            @Override
            public void onFailure(Call<UserBean[]> call, Throwable t) {

            }
        });
    }

    //获取关注列表
    @Override
    public void getFollowing() {

        followingModel.getFollowing(followingBean, new Callback<UserBean[]>() {
            @Override
            public void onResponse(Call<UserBean[]> call, Response<UserBean[]> response) {

            }

            @Override
            public void onFailure(Call<UserBean[]> call, Throwable t) {

            }
        });
    }

    //取关或关注
    @Override
    public void follow() {

            followingModel.follow(followingBean, new Callback<UserFollowingBean>() {
                @Override
                public void onResponse(Call<UserFollowingBean> call, Response<UserFollowingBean> response) {

                }

                @Override
                public void onFailure(Call<UserFollowingBean> call, Throwable t) {

                }
            });
    }

    //移除粉丝
    @Override
    public void removeFollower() {

        followerModel.removeFollower(followerBean, new Callback<UserFollowerBean>() {
            @Override
            public void onResponse(Call<UserFollowerBean> call, Response<UserFollowerBean> response) {

            }

            @Override
            public void onFailure(Call<UserFollowerBean> call, Throwable t) {

            }
        });

    }


    public UserFollowerPresenter(BaseView baseView) {
        super(baseView);
    }

    public void setupFollowerTask(CommonBean bean, BaseView view){
        followingBean = (UserFollowingBean)bean;
        this.view = (UserFollowContract.View)view;
        followerModel = new FollowerModelImpl(this);
    }

    public void setupFollowingTask(CommonBean bean, BaseView view){
        followingBean = (UserFollowingBean)bean;
        this.view = (UserFollowContract.View)view;
        followingModel = new FollowingModelImpl(this);
    }


    @Override
    public void setupTask(CommonBean bean) {

    }

}
