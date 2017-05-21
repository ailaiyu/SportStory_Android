package cn.sportstory.android.nearby.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserSearchBean;

/**
 * Created by aaron on 2017/5/21.
 */

public interface UserSearchContract {
    abstract class Presenter implements BasePresenter{

    }

    abstract class View extends BaseView<Presenter> {
        abstract public void searchUserFailed(UserSearchBean bean);     //搜索失败
        abstract public void searchUserSuccess(UserSearchBean bean);    //搜索成功
        abstract public void searchUserNoMore(UserSearchBean bean);     //没有更多用户
    }

}
