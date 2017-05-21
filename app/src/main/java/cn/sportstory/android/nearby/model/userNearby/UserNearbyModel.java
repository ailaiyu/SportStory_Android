package cn.sportstory.android.nearby.model.userNearby;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.UserNearbyBean;
import cn.sportstory.android.nearby.contract.UserNearbyContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UserNearbyModel extends BaseModel {
    private UserNearbyContract.Presenter presenter;

    public UserNearbyModel(UserNearbyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void getUserNearby(UserNearbyBean bean, Callback<UserNearbyBean> callback);

}
