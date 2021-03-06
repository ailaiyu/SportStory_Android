package cn.sportstory.android.account.model.updateUserInfo;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UpdateUserSport extends UpdateUserInfoModel {

    public UpdateUserSport(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void updateUserInfo(UserBean bean, Callback<UserBean> callback) {
        Call<UserBean> repos = service.updateUserSport(bean);
        repos.enqueue(callback);

    }
}
