package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserAccountBean;

/**
 * Created by aaron on 2017/6/6.
 */

public interface UpdateAccountInfoContract {
    public abstract class Presenter implements BasePresenter{
        public abstract void changePhone();
        public abstract void changeEmail();
        public abstract void changePassword();
    }

    public abstract class View extends BaseView<Presenter> {
        abstract protected void showUpdatePhoneSuccess(UserAccountBean bean);
        abstract protected void showUpdatePhoneFailed(UserAccountBean bean);
        abstract protected void showUpdateEmailSuccess(UserAccountBean bean);
        abstract protected void showUpdateEmailFailed(UserAccountBean bean);
        abstract protected void showUpdatePasswordSuccess(UserAccountBean bean);
        abstract protected void showUpdatePasswordFailed(UserAccountBean bean);

    }
}
