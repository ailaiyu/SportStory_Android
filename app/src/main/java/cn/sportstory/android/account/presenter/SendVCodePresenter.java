package cn.sportstory.android.account.presenter;

import cn.sportstory.android.R;
import cn.sportstory.android.account.contract.SendVCodeTaskContract;
import cn.sportstory.android.account.model.sendVCode.SendVCodeModel;
import cn.sportstory.android.account.model.sendVCode.SendVCodeModelImpl;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.tools.ResponseParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/19.
 */

public class SendVCodePresenter extends SendVCodeTaskContract.Presenter {
    private SendVCodeModel model;
    private SendVCodeBean bean;

    public SendVCodePresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {
        model.sendVCode(bean, new Callback<SendVCodeBean>() {
            @Override
            public void onResponse(Call<SendVCodeBean> call, Response<SendVCodeBean> response) {
                ResponseParser.parseResponse(response, view);
                if (response.code() == ResponseParser.RESPONSE_ERR){
                        return;
                }else if (response.code() == ResponseParser.RESPONSE_CODE_OK){
                    ((SendVCodeTaskContract.View)view).showSendSuccess();
                }else {
                    view.showError(view.getViewContext().getString(R.string.server_error));
                }
            }

            @Override
            public void onFailure(Call<SendVCodeBean> call, Throwable t) {
                view.showNetDisconnect();
            }
        });
    }

    @Override
    public void setupTask(CommonBean bean) {
        model = new SendVCodeModelImpl(this);
        this.bean = (SendVCodeBean)bean;
    }

}
