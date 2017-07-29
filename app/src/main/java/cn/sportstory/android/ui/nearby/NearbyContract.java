package cn.sportstory.android.ui.nearby;

import java.util.List;

import cn.sportstory.android.entity.SimpleUserInfo;
import cn.sportstory.android.entity.SimpleUserInfoWithLocation;
import cn.sportstory.android.ui.base.BasePresenter;
import cn.sportstory.android.ui.base.BaseView;

/**
 * Created by Tamas on 2017/7/6.
 */

public interface NearbyContract {
    interface View extends BaseView<Presenter>{
        void onNearbyUserListFetched(List<SimpleUserInfoWithLocation> userInfoList);
    }
    interface Presenter extends BasePresenter{
        void fetchNearbyUserList();
    }
}
