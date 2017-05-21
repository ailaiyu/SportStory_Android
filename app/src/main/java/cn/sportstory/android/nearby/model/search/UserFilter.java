package cn.sportstory.android.nearby.model.search;

import cn.sportstory.android.common.bean.UserSearchBean;
import cn.sportstory.android.nearby.contract.UserSearchContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserFilter extends UserSearchModel {

    public UserFilter(UserSearchContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void searchUser(UserSearchBean bean, Callback<UserSearchBean> callback) {

    }
}
