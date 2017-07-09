package cn.sportstory.android.account.model.updateAccountInfo;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserAccountBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/6/6.
 */

public class ChangePassword extends UpdateAccountInfoModel{
    public ChangePassword(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void updateEmail(UserAccountBean bean, Callback<UserAccountBean> callback) {
        Call<UserAccountBean> repos = service.changePhone(bean);
        repos.enqueue(callback);
    }
}
