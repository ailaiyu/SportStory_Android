package cn.sportstory.android.nearby.model.userNearby;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserNearbyBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UserNearbyModel extends BaseModel {
    public UserNearbyModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void getUserNearby(UserNearbyBean bean, Callback<UserNearbyBean> callback);

}
