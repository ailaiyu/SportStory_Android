package cn.sportstory.android.account.model.updateAccountInfo;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UpdateAccountInfoContract;
import cn.sportstory.android.common.bean.UserAccountBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/6/6.
 */

public class ChangeEmail extends UpdateAccountInfoModel{
    public ChangeEmail(UpdateAccountInfoContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void updateEmail(UserAccountBean bean, Callback<UserAccountBean> callback) {
        super.updateEmail(bean, callback);
        super.updatePhone(bean, callback);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("email", bean.getEmail());
        map.put("code", bean.getCode());
        Call<UserAccountBean> repos = service.changePhone(map);
        repos.enqueue(callback);
    }
}
