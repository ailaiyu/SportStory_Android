package cn.sportstory.android.nearby.model.search;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.UserSearchBean;
import cn.sportstory.android.nearby.contract.UserSearchContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UserSearchModel extends BaseModel{
    private UserSearchContract.Presenter presenter;

    public UserSearchModel(UserSearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void searchUser(UserSearchBean bean, Callback<UserSearchBean> callback);
}
