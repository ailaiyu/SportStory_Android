package cn.sportstory.android.account.model.updateAccountInfo;

import android.content.Context;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UpdateAccountInfoContract;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserAccountBean;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/6/6.
 */

public class ChangePhone extends UpdateAccountInfoModel {


    public ChangePhone(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void updatePhone(UserAccountBean bean, Callback<UserAccountBean> callback) {
        super.updatePhone(bean, callback);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("phone", bean.getPhone());
        map.put("code", bean.getCode());
        Call<UserAccountBean> repos = service.changePhone(map);
        repos.enqueue(callback);
    }
}
