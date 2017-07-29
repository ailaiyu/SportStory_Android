package cn.sportstory.android.ui.addmoment;

import java.util.List;

import cn.sportstory.android.ui.base.BasePresenter;
import cn.sportstory.android.ui.base.BaseView;

/**
 * Created by Tamas on 2017/7/28.
 */

public interface AddMomentContract {
    interface View extends BaseView<Presenter>{
        void onPostMomentSuccess();
        void onPostMomentFail(String msg);
    }
    interface Presenter extends BasePresenter{
        void postMoment(List<String> imagePathList,String content);

    }
}
