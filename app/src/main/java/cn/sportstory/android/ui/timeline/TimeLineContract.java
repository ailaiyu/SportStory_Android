package cn.sportstory.android.ui.timeline;

import java.util.List;

import cn.sportstory.android.entity.Story;
import cn.sportstory.android.ui.base.BasePresenter;
import cn.sportstory.android.ui.base.BaseView;

/**
 * Created by Tamas on 2017/7/9.
 */

public interface TimeLineContract {
    interface View extends BaseView<Presenter>{
        void onTimeLineFetched(List<Story> storyList);
    }
    interface Presenter extends BasePresenter{
        void fetchTimeLine();
    }
}
