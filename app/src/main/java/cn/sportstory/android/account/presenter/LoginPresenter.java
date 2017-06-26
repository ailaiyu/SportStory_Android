package cn.sportstory.android.account.presenter;

import android.text.TextUtils;
import android.widget.TextView;

import cn.sportstory.android.R;
import cn.sportstory.android.account.contract.LoginTaskContract;
import cn.sportstory.android.account.model.login.LoginEmailPassword;
import cn.sportstory.android.account.model.login.LoginEmailVCode;
import cn.sportstory.android.account.model.login.LoginModel;
import cn.sportstory.android.account.model.login.LoginPhonePassword;
import cn.sportstory.android.account.model.login.LoginPhoneVCode;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.ErrorBody;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.common.tools.ResponseParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static cn.sportstory.android.common.bean.UserLoginBean.LOGIN_TYPE_EMAIL_PASSWORD;
import static cn.sportstory.android.common.bean.UserLoginBean.LOGIN_TYPE_EMAIL_VCODE;
import static cn.sportstory.android.common.bean.UserLoginBean.LOGIN_TYPE_PHONE_PASSWORD;
import static cn.sportstory.android.common.bean.UserLoginBean.LOGIN_TYPE_PHONE_VCODE;

/**
 * Created by aaron on 2017/5/17.
 */

public class LoginPresenter extends LoginTaskContract.Presenter {


    private static final String IS_VALID_REGISTER = "00";
    private LoginModel loginModel;
    private UserLoginBean bean;

    public LoginPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void setupTask(CommonBean commonBean) {
        bean = (UserLoginBean)commonBean;
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
        bean.setLoginType(null);
    }




    @Override
    public void doTask() {
        loginModel.login(bean, new Callback<UserLoginBean>() {
            @Override
            public void onResponse(Call<UserLoginBean> call, Response<UserLoginBean> response) {

                ResponseParser.parseResponse(response, view);
                UserLoginBean bean = response.body();
                if (response.code() == ResponseParser.RESPONSE_CODE_OK){
                    if (!TextUtils.isEmpty(bean.getIs_valid()) && bean.getIs_valid().equals(IS_VALID_REGISTER))
                    {
                        ((LoginTaskContract.View)view).register();
                    }else
                        ((LoginTaskContract.View)view).loginSuccess();
                }else if (response.code() == ResponseParser.RESPONSE_ERR)
                {
                    return;
                }else {
                    view.showError(view.getViewContext().getString(R.string.common_error));
                }
            }

            @Override
            public void onFailure(Call<UserLoginBean> call, Throwable t) {
                view.showNetDisconnect();
            }
        });

    }




}
