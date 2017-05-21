package cn.sportstory.android.account.model.uploadUserLocation;

import cn.sportstory.android.account.contract.UploadUserLocationContract;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.UserLocationBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UploadUserLocationModel extends BaseModel {
    private UploadUserLocationContract.Presenter presenter;

    public UploadUserLocationModel(UploadUserLocationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void uploadLocation(UserLocationBean bean, Callback<UserLocationBean> callback);
}
