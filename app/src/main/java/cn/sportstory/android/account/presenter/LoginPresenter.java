package cn.sportstory.android.account.presenter;

import cn.sportstory.android.account.contract.LoginTaskContract;
import cn.sportstory.android.account.model.login.LoginEmailPassword;
import cn.sportstory.android.account.model.login.LoginEmailVCode;
import cn.sportstory.android.account.model.login.LoginModel;
import cn.sportstory.android.account.model.login.LoginPhonePassword;
import cn.sportstory.android.account.model.login.LoginPhoneVCode;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.im.UserLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/17.
 */

public class LoginPresenter implements LoginTaskContract.Presenter {

    private LoginTaskContract.View view;
    private static final int LOGIN_TYPE_PHONE_VCODE = 1;
    private static final int LOGIN_TYPE_PHONE_PASSWORD = 2;
    private static final int LOGIN_TYPE_EMAIL_VCODE = 3;
    private static final int LOGIN_TYPE_EMAIL_PASSWORD = 4;
    private LoginModel loginModel;
    private UserLoginBean bean;

    @Override
    public void setupTask(CommonBean commonBean, BaseView view) {
        bean = (UserLoginBean)commonBean;
        this.view = (LoginTaskContract.View) view;
        switch (bean.getLoginType())
        {
            case LOGIN_TYPE_PHONE_VCODE:
                loginModel = new LoginPhoneVCode(this);
                break;
            case LOGIN_TYPE_EMAIL_PASSWORD:
                loginModel = new LoginEmailPassword(this);
                break;
            case LOGIN_TYPE_EMAIL_VCODE:
                loginModel = new LoginEmailVCode(this);
                break;
            case LOGIN_TYPE_PHONE_PASSWORD:
                loginModel = new LoginPhonePassword(this);
                break;
        }
    }


    @Override
    public void doTask() {
        loginModel.login(bean, new Callback<UserLoginBean>() {
            @Override
            public void onResponse(Call<UserLoginBean> call, Response<UserLoginBean> response) {

            }

            @Override
            public void onFailure(Call<UserLoginBean> call, Throwable t) {

            }
        });

    }


}
