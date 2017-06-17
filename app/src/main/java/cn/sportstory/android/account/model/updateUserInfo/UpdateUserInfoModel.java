package cn.sportstory.android.account.model.updateUserInfo;

import android.content.Context;

import cn.sportstory.android.account.contract.UpdateUserInfoContract;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UpdateUserInfoModel extends BaseModel {
    public UpdateUserInfoModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void updateUserInfo(UserBean bean, Callback<UserBean> callback);
}
