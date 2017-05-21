package cn.sportstory.android.nearby.presenter;

import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserNearbyBean;
import cn.sportstory.android.nearby.contract.UserNearbyContract;
import cn.sportstory.android.nearby.model.userNearby.UserNearby;
import cn.sportstory.android.nearby.model.userNearby.UserNearbyModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserNearbyPresenter extends UserNearbyContract.Presenter {
    private UserNearbyModel model;
    private UserNearbyContract.View view;
    private UserNearbyBean bean;

    @Override
    public void doTask() {

        model.getUserNearby(bean, new Callback<UserNearbyBean>() {
            @Override
            public void onResponse(Call<UserNearbyBean> call, Response<UserNearbyBean> response) {

            }

            @Override
            public void onFailure(Call<UserNearbyBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean, BaseView view) {
        this.bean = (UserNearbyBean) bean;
        this.view = (UserNearbyContract.View) view;
        model = new UserNearby(this);
    }
}
