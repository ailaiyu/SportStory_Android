package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;

/**
 * Created by aaron on 2017/5/21.
 */

public interface UploadUserLocationContract {

    abstract class Presenter implements BasePresenter{

    }

    abstract class View extends BaseView<UploadUserLocationContract.Presenter>{
        abstract void uploadAddressFailed();
        abstract void uploadAddressSuccess();
    }
}
