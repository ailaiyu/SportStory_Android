package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;

/**
 * Created by aaron on 2017/5/20.
 */

public interface UploadPhoneInfoContract {
    abstract class View extends BaseView<Presenter>{
        abstract public void uploadFailed();    //上传信息失败
        abstract public void uploadSuccess();   //上传信息成功
    }

    abstract class Presenter extends BasePresenter{
        public Presenter(BaseView baseView) {
            super(baseView);
        }
    }
}
