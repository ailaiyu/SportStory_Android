package cn.sportstory.android.account.presenter;

import cn.sportstory.android.account.contract.UpdateAccountInfoContract;
import cn.sportstory.android.account.model.updateAccountInfo.ChangeEmail;
import cn.sportstory.android.account.model.updateAccountInfo.ChangePassword;
import cn.sportstory.android.account.model.updateAccountInfo.ChangePhone;
import cn.sportstory.android.account.model.updateAccountInfo.UpdateAccountInfoModel;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserAccountBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/6/6.
 */

public class UpdateAccountInfoPresenter extends UpdateAccountInfoContract.Presenter {



    private UpdateAccountInfoModel model;
    private UserAccountBean bean;
    @Override
    public void doTask() {

    }

    public UpdateAccountInfoPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void changePhone() {
        model = new ChangePhone(this);
        model.updatePhone(bean, new Callback<UserAccountBean>() {
            @Override
            public void onResponse(Call<UserAccountBean> call, Response<UserAccountBean> response) {

            }

            @Override
            public void onFailure(Call<UserAccountBean> call, Throwable t) {
                view.showNetDisconnect();
            }
        });
    }

    @Override
    public void changeEmail() {
        model = new ChangeEmail(this);
        model.updateEmail(bean, new Callback<UserAccountBean>() {
            @Override
            public void onResponse(Call<UserAccountBean> call, Response<UserAccountBean> response) {

            }

            @Override
            public void onFailure(Call<UserAccountBean> call, Throwable t) {

            }

        });
    }

    @Override
    public void changePassword() {

        model = new ChangePassword(this);
        model.updatePassword(bean, new Callback<UserAccountBean>() {
            @Override
            public void onResponse(Call<UserAccountBean> call, Response<UserAccountBean> response) {

            }

            @Override
            public void onFailure(Call<UserAccountBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean) {
        this.bean = (UserAccountBean) bean;
    }
}
