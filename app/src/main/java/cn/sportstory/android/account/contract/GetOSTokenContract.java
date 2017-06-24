package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.OSTokenBean;

/**
 * Created by aaron on 2017/6/22.
 */

public interface GetOSTokenContract {
    abstract class Presenter extends BasePresenter {
        public Presenter(BaseView baseView) {
            super(baseView);
        }
    }

    abstract class View extends BaseView<Presenter>{
        abstract public void getTokenSuccess(OSTokenBean bean);
        abstract public void getTokenFailed(OSTokenBean bean);
    }
}
