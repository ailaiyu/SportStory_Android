package cn.sportstory.android.account.model.uploadPhoneInfo;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.PhoneInfoBean;
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
