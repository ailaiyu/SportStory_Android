package cn.sportstory.android.account.model.login;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.presenter.LoginPresenter;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/17.
 */

public class LoginEmailVCode extends LoginModel {

    public LoginEmailVCode(LoginPresenter presenter) {
        super(presenter);
    }

    @Override
    public void login(UserLoginBean bean, Callback<UserLoginBean> callback) {
        Call<UserLoginBean> repos = service.userLogin(bean);
        repos.enqueue(callback);
    }
}
