package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserLoginBean;

/**
 * Created by aaron on 2017/5/17.
 */

public interface LoginTaskContract {

    interface View extends BaseView<Presenter> {
        void showVCodeError();              //验证码错误
        void showSendVCodeFailed();         // 发送验证码失败
        void showServerError();             //服务器错误
        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void setUpTask(UserLoginBean bean);               //登录
    }
}
