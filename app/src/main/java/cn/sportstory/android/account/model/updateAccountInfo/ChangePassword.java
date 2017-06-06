package cn.sportstory.android.account.model.updateAccountInfo;

import android.text.TextUtils;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UpdateAccountInfoContract;
import cn.sportstory.android.common.bean.UserAccountBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/6/6.
 */

public class ChangePassword extends UpdateAccountInfoModel{
    public ChangePassword(UpdateAccountInfoContract.Presenter presenter) {
        super(presenter);
    }
    
    @Override
    public void updateEmail(UserAccountBean bean, Callback<UserAccountBean> callback) {
        super.updateEmail(bean, callback);
        super.updatePhone(bean, callback);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("type", bean.getType());
        map.put("password", bean.getPassword());
        map.put("code", bean.getCode());
        Call<UserAccountBean> repos = service.changePhone(map);
        repos.enqueue(callback);
    }
}
