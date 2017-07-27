package cn.sportstory.android.ui.login.password;

import cn.sportstory.android.ui.base.BasePresenter;
import cn.sportstory.android.ui.base.BaseView;

/**
 * Created by Tamas on 2017/7/27.
 */

public interface PasswordLoginContract {
    interface View extends BaseView<Presenter>{
        void onLoginSuccess();
        void onLoginFail(String msg);
    }
    interface Presenter extends BasePresenter{
        void login(String account,String passWord);
    }
}
