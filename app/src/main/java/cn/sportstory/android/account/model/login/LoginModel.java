package cn.sportstory.android.account.model.login;

import android.content.Context;

import cn.sportstory.android.account.presenter.LoginPresenter;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserLocationBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.im.UserLogin;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/17.
 */

public abstract class LoginModel extends BaseModel {

    public LoginModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void login(UserLoginBean bean, Callback<UserLoginBean> callback);
}
