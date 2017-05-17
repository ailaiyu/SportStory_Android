package cn.sportstory.android.account.presenter;

import cn.sportstory.android.account.contract.LoginTaskContract;
import cn.sportstory.android.account.model.login.LoginEmailPassword;
import cn.sportstory.android.account.model.login.LoginEmailVCode;
import cn.sportstory.android.account.model.login.LoginModel;
import cn.sportstory.android.account.model.login.LoginPhonePassword;
import cn.sportstory.android.account.model.login.LoginPhoneVCode;
import cn.sportstory.android.common.bean.UserLoginBean;

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
    public void setUpTask(UserLoginBean bean) {
        switch (bean.getLoginType())
        {
            case LOGIN_TYPE_PHONE_VCODE:
                loginModel = new LoginPhoneVCode();
                break;
            case LOGIN_TYPE_EMAIL_PASSWORD:
                loginModel = new LoginEmailPassword();
                break;
            case LOGIN_TYPE_EMAIL_VCODE:
                loginModel = new LoginEmailVCode();
                break;
            case LOGIN_TYPE_PHONE_PASSWORD:
                loginModel = new LoginPhonePassword();
                break;
        }
        this.bean = bean;
    }

    @Override
    public void start() {
        loginModel.login(bean);
    }


}
