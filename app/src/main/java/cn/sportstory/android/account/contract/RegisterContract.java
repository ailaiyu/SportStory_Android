package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserBean;

/**
 * Created by aaron on 2017/5/20.
 */

public interface RegisterContract {
    abstract class Presenter extends BasePresenter{
        public Presenter(BaseView baseView) {
            super(baseView);
        }
    }

    abstract class RegisterView extends BaseView{
        abstract public void showRegisterSuccess(UserBean userBean);
    }
}
