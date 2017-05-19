package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;

/**
 * Created by aaron on 2017/5/19.
 */

public interface SendVCodeTaskContract {
    interface View extends BaseView<Presenter>{
        void showSendFailed();
        void showSendSuccess();
    }

    interface Presenter extends BasePresenter {

    }
}
