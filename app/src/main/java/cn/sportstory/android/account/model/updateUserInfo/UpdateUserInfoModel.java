package cn.sportstory.android.account.model.updateUserInfo;

import cn.sportstory.android.account.contract.UpdateUserInfoContract;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UpdateUserInfoModel extends BaseModel {
    private UpdateUserInfoContract.Presenter presenter;

    public UpdateUserInfoModel(UpdateUserInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void updateUserInfo(UserBean bean, Callback<UserBean> callback);
}
