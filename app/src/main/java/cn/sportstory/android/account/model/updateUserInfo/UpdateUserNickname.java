package cn.sportstory.android.account.model.updateUserInfo;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UpdateUserNickname extends UpdateUserInfoModel {
    public UpdateUserNickname(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void updateUserInfo(UserBean bean, Callback<UserBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("nickname", bean.getNickname());
        Call<UserBean> repos = service.updateNickname(map);
        repos.enqueue(callback);

    }
}
