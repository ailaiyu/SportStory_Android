package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;

/**
 * Created by aaron on 2017/5/17.
 */

public interface LoginTaskContract {

    abstract class View extends BaseView<Presenter> {
        protected abstract void showVCodeError();              //验证码错误

        protected abstract boolean isActive();
        public abstract void loginSuccess();
        public abstract void register();
    }

    abstract class Presenter extends BasePresenter {
        public Presenter(BaseView baseView) {
            super(baseView);
        }


    }
}
