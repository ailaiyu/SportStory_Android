package cn.sportstory.android.account.presenter;

import android.text.TextUtils;

import cn.sportstory.android.R;
import cn.sportstory.android.account.contract.GetOSTokenContract;
import cn.sportstory.android.account.contract.LoginTaskContract;
import cn.sportstory.android.account.model.osToken.GetOSTokenModel;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.OSTokenBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.common.tools.ResponseParser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/6/22.
 */

public class GetOsTokenPresenter extends GetOSTokenContract.Presenter {

    private GetOSTokenModel model;
    private OSTokenBean bean;
    public GetOsTokenPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {

        model.getToken(bean, new Callback<OSTokenBean>() {
            @Override
            public void onResponse(Call<OSTokenBean> call, Response<OSTokenBean> response) {
                ResponseParser.parseResponse(response, view);
                OSTokenBean bean = response.body();
                if (response.code() == ResponseParser.RESPONSE_ERR) {
                    return;
                }
                if (response.code() == ResponseParser.RESPONSE_CODE_OK) {
                    ((GetOSTokenContract.View) view).getTokenSuccess(bean);
                } else {
                    view.showError(view.getViewContext().getString(R.string.common_error));
                }

            }

            @Override
            public void onFailure(Call<OSTokenBean> call, Throwable t) {
                view.showNetDisconnect();
            }
        });
    }

    @Override
    public void setupTask(CommonBean bean) {
        this.bean = (OSTokenBean)bean;
        model = new GetOSTokenModel(this);
    }
}
