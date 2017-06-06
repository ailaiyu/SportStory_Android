package cn.sportstory.android.account.model.updateAccountInfo;

import cn.sportstory.android.account.contract.UpdateAccountInfoContract;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.UserAccountBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/6/6.
 */

public abstract class UpdateAccountInfoModel extends BaseModel{
    private UpdateAccountInfoContract.Presenter presenter;

    public UpdateAccountInfoModel(UpdateAccountInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void updatePhone(UserAccountBean bean, Callback<UserAccountBean> callback){}

    public void updateEmail(UserAccountBean bean, Callback<UserAccountBean> callback){}

    public void updatePassword(UserAccountBean bean, Callback<UserAccountBean> callback){}
}
