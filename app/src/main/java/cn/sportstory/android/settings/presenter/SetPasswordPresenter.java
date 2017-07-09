package cn.sportstory.android.settings.presenter;

import cn.sportstory.android.R;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserPasswordBean;
import cn.sportstory.android.common.tools.ResponseParser;
import cn.sportstory.android.settings.contract.SetPasswordContract;
import cn.sportstory.android.settings.model.SetPasswordModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/7/1.
 */

public class SetPasswordPresenter extends SetPasswordContract.Presenter {
    private SetPasswordModel passwordModel;
    private UserPasswordBean bean;
    public SetPasswordPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {

        passwordModel.setPassword(bean, new Callback<UserPasswordBean>() {
            @Override
            public void onResponse(Call<UserPasswordBean> call, Response<UserPasswordBean> response) {
                ResponseParser.parseResponse(response, view);
                UserPasswordBean bean = response.body();
                if (response.code() == ResponseParser.RESPONSE_ERR) {
                    return;
                }
                if (response.code() == ResponseParser.RESPONSE_CODE_OK) {
                    ((SetPasswordContract.View) view).setSuccess(bean);
                } else {
                    view.showError(view.getViewContext().getString(R.string.common_error));
                }
            }

            @Override
            public void onFailure(Call<UserPasswordBean> call, Throwable t) {
                ((SetPasswordContract.View) view).setFailed();
            }
        });
    }

    @Override
    public void setupTask(CommonBean bean) {
        this.bean = (UserPasswordBean)bean;
        passwordModel = new SetPasswordModel(this);
    }
}
