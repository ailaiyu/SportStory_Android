package cn.sportstory.android.nearby.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserNearbyBean;

/**
 * Created by aaron on 2017/5/21.
 */

public interface NearbyContract {

    abstract class Presenter extends BasePresenter {
        public Presenter(BaseView baseView) {
            super(baseView);
        }
    }

    abstract class View extends BaseView<Presenter> {
        abstract void getUserFailed(UserNearbyBean bean);       //获取用户失败
        abstract void getUserSuccess(UserNearbyBean bean);      //获取到足够的用户数
        abstract void getUserNoMore(UserNearbyBean bean);       //已经没有更多： 用户数为0或者少于num
    }
}
