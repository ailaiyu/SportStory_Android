package cn.sportstory.android.settings.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserPasswordBean;

/**
 * Created by aaron on 2017/7/1.
 */

public interface SetPasswordContract {

    abstract class View extends BaseView<Presenter> {
        public abstract void setSuccess(UserPasswordBean bean);              //验证码错误
        public abstract void setFailed();
    }

    abstract class Presenter extends BasePresenter {
        public Presenter(BaseView baseView) {
            super(baseView);
        }
    }
}
