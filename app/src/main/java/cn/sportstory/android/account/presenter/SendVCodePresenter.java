package cn.sportstory.android.account.presenter;

import cn.sportstory.android.account.contract.SendVCodeTaskContract;
import cn.sportstory.android.account.model.sendVCode.SendVCodeModel;
import cn.sportstory.android.account.model.sendVCode.SendVCodeModelImpl;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.SendVCodeBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/19.
 */

public class SendVCodePresenter implements SendVCodeTaskContract.Presenter {
    private SendVCodeModel model;
    private SendVCodeBean bean;
    private SendVCodeTaskContract.View view;
    @Override
    public void doTask() {
        model.sendVCode(bean, new Callback<SendVCodeBean>() {
            @Override
            public void onResponse(Call<SendVCodeBean> call, Response<SendVCodeBean> response) {

            }

            @Override
            public void onFailure(Call<SendVCodeBean> call, Throwable t) {
                view.showSendVCodeFailed();
            }
        });
    }

    @Override
    public void setupTask(CommonBean bean, BaseView view) {
        model = new SendVCodeModelImpl(this);
        this.bean = (SendVCodeBean)bean;
        this.view = (SendVCodeTaskContract.View)view;
    }
}
