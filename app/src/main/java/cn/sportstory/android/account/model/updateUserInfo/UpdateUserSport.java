package cn.sportstory.android.account.model.updateUserInfo;

import android.content.Context;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UpdateUserInfoContract;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UpdateUserSport extends UpdateUserInfoModel {

    public UpdateUserSport(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void updateUserInfo(UserBean bean, Callback<UserBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        Gson gson = new Gson();
        map.put("sport", gson.toJson(bean.getSport()));
        Call<UserBean> repos = service.updateUserSport(map);
        repos.enqueue(callback);

    }
}
