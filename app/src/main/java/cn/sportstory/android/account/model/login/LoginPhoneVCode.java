package cn.sportstory.android.account.model.login;

import cn.sportstory.android.account.presenter.LoginPresenter;
import cn.sportstory.android.common.bean.UserLoginBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/17.
 */

public class LoginPhoneVCode extends LoginModel {

    public LoginPhoneVCode(LoginPresenter presenter) {
        super(presenter);
    }

    @Override
    public void login(UserLoginBean bean, Callback<UserLoginBean> callback) {

    }
}
