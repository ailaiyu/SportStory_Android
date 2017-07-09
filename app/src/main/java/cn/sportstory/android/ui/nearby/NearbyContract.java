package cn.sportstory.android.ui.nearby;

import cn.sportstory.android.ui.base.BasePresenter;
import cn.sportstory.android.ui.base.BaseView;

/**
 * Created by Tamas on 2017/7/6.
 */

public interface NearbyContract {
    interface View extends BaseView<Presenter>{

    }
    interface Presenter extends BasePresenter{
        void fetchNearbyUserList();
    }
}
