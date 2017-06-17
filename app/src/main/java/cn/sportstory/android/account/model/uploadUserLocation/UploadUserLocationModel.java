package cn.sportstory.android.account.model.uploadUserLocation;

import android.content.Context;

import cn.sportstory.android.account.contract.UploadUserLocationContract;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserLocationBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UploadUserLocationModel extends BaseModel {
    public UploadUserLocationModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void uploadLocation(UserLocationBean bean, Callback<UserLocationBean> callback);
}
