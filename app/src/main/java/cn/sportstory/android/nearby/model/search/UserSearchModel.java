package cn.sportstory.android.nearby.model.search;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserSearchBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UserSearchModel extends BaseModel{

    public UserSearchModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void searchUser(UserSearchBean bean, Callback<UserSearchBean> callback);
}
