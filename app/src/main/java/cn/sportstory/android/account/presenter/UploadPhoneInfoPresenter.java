package cn.sportstory.android.account.presenter;

import cn.sportstory.android.account.contract.UploadPhoneInfoContract;
import cn.sportstory.android.account.model.uploadPhoneInfo.UploadPhoneInfoModelImpl;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.PhoneInfoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/20.
 */

public class UploadPhoneInfoPresenter extends UploadPhoneInfoContract.Presenter {

    private PhoneInfoBean bean;
    private UploadPhoneInfoModelImpl model;

    @Override
    public void setupTask(CommonBean bean) {
        model = new UploadPhoneInfoModelImpl(this);
        this.bean = (PhoneInfoBean) bean;
    }

    public UploadPhoneInfoPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {

        model.uploadPhoneInfo(bean, new Callback<PhoneInfoBean>() {
            @Override
            public void onResponse(Call<PhoneInfoBean> call, Response<PhoneInfoBean> response) {
                String token = response.headers().get("header");
                String err = response.headers().get("err");
                String success = response.headers().get("success");
            }

            @Override
            public void onFailure(Call<PhoneInfoBean> call, Throwable t) {
                view.showNetDisconnect();
            }
        });
    }

}
