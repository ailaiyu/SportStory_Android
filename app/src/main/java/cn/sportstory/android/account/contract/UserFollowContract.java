package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserFollowerBean;

/**
 * Created by aaron on 2017/5/28.
 */

public interface UserFollowContract {
    abstract class Presenter implements BasePresenter {
        @Override
        public void doTask() {

        }

        @Override
        public void setupTask(CommonBean bean, BaseView view) {

        }

        abstract public void getFollowers();
        abstract public void getFollowing();
        abstract public void follow();
        abstract public void removeFollower();

    }


    abstract public class View extends BaseView<Presenter> {

        abstract public void getFollowersSuccess(UserBean[] users);
        abstract public void getFollowersFailed(UserBean[] users);
        abstract public void followSuccess(UserFollowerBean bean);
        abstract public void followFailed(UserFollowerBean bean);
    }
}
