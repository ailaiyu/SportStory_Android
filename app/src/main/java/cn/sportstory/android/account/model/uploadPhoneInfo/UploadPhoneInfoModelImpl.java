package cn.sportstory.android.account.model.uploadPhoneInfo;

import android.content.Context;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UploadPhoneInfoContract;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.PhoneInfoBean;
import cn.sportstory.android.common.bean.SendVCodeBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/20.
 */

public class UploadPhoneInfoModelImpl extends UploadPhoneInfoModel {

    public UploadPhoneInfoModelImpl(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void uploadPhoneInfo(PhoneInfoBean bean, Callback<PhoneInfoBean> callback) {
        Call<PhoneInfoBean> repos = service.uploadPhoneInfo(bean);
        repos.enqueue(callback);
    }
}
