package cn.sportstory.android.nearby.model.search;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.common.bean.UserNearbyBean;
import cn.sportstory.android.common.bean.UserSearchBean;
import cn.sportstory.android.nearby.contract.UserSearchContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserSearch extends UserSearchModel {
    public UserSearch(UserSearchContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void searchUser(UserSearchBean bean, Callback<UserSearchBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("keyword", bean.getKeyword());
        map.put("start", bean.getStart());
        map.put("num", bean.getNum());
        Call<UserSearchBean> repos = service.searchUser(map);
        repos.enqueue(callback);
    }
}
