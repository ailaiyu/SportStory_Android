package cn.sportstory.android.account.model.updateAccountInfo;

import android.content.Context;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UpdateAccountInfoContract;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserAccountBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/6/6.
 */

public class ChangeEmail extends UpdateAccountInfoModel{
    public ChangeEmail(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void updateEmail(UserAccountBean bean, Callback<UserAccountBean> callback) {
        Call<UserAccountBean> repos = service.changePhone(bean);
        repos.enqueue(callback);
    }
}
