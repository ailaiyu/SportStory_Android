package cn.sportstory.android.nearby.presenter;

import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserSearchBean;
import cn.sportstory.android.nearby.contract.UserSearchContract;
import cn.sportstory.android.nearby.model.search.UserFilter;
import cn.sportstory.android.nearby.model.search.UserSearch;
import cn.sportstory.android.nearby.model.search.UserSearchModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserSearchPresenter extends UserSearchContract.Presenter {
    private UserSearchModel model;
    private UserSearchBean bean;

    private static final int USER_SEARCH_TYPE_SEARCH = 1;
    private static final int USER_SEARCH_TYPE_FILTER = 2;

    public UserSearchPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doTask() {

        model.searchUser(bean, new Callback<UserSearchBean>() {
            @Override
            public void onResponse(Call<UserSearchBean> call, Response<UserSearchBean> response) {

            }

            @Override
            public void onFailure(Call<UserSearchBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean) {
        this.bean = (UserSearchBean)bean;
        switch (((UserSearchBean) bean).getSearchType()){
            case USER_SEARCH_TYPE_FILTER:
                model = new UserFilter(this);
                break;
            case USER_SEARCH_TYPE_SEARCH:
                model = new UserSearch(this);
                break;
        }

    }
}
