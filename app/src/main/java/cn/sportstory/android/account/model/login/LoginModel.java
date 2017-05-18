package cn.sportstory.android.account.model.login;

import cn.sportstory.android.common.bean.UserLocationBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.im.UserLogin;

/**
 * Created by aaron on 2017/5/17.
 */

public abstract class LoginModel {
    abstract public void login(UserLoginBean bean);

}
