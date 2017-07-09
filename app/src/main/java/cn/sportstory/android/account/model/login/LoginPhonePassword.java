package cn.sportstory.android.account.model.login;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserLoginBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/17.
 */

public class LoginPhonePassword extends LoginModel {

    public LoginPhonePassword(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void login(UserLoginBean bean, Callback<UserLoginBean> callback) {
        Call<UserLoginBean> repos = service.userLogin(bean);
        repos.enqueue(callback);
    }
}
