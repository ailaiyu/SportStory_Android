package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;

/**
 * Created by aaron on 2017/5/20.
 */

public interface UserLoginContract {
    abstract class View extends BaseView{
        public abstract void gotoRegister();        //注册
        public abstract void needPerfectInfo();     //需要完善信息
        public abstract void loginSuccess();        //登录成功
    }

    abstract class Presenter extends BasePresenter{
        public Presenter(BaseView baseView) {
            super(baseView);
        }
    }
}
