package cn.sportstory.android.timeline.contract;

import cn.sportstory.android.account.contract.UploadPhoneInfoContract;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.TimelineBean;

/**
 * Created by aaron on 2017/5/28.
 */

public interface TimelineDelContract {
    abstract class Presenter implements BasePresenter {

    }

    abstract class View extends BaseView<Presenter> {
        abstract public void delSuccess(TimelineBean bean);
        abstract public void delFailed(TimelineBean bean);

    }
}
