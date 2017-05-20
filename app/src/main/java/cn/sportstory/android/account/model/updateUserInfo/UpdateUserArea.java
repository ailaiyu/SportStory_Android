package cn.sportstory.android.account.model.updateUserInfo;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UpdateUserInfoContract;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UpdateUserArea extends UpdateUserInfoModel {

    public UpdateUserArea(UpdateUserInfoContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void updateUserInfo(UserBean bean, Callback<UserBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("province", bean.getProvince());
        map.put("city", bean.getCity());
        map.put("district", bean.getDistrict());
        map.put("address", bean.getAddress());
        Call<UserBean> repos = service.updateUserArea(map);
        repos.enqueue(callback);

    }
}
