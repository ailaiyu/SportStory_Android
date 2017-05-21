package cn.sportstory.android.timeline.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.common.bean.TimelineFollowBean;

/**
 * Created by aaron on 2017/5/21.
 */

public interface TimelineFollowContract {
    abstract class Presenter implements BasePresenter{}

    abstract class View extends BaseView<Presenter>{
        abstract void getTimelineSuccess(TimelineFollowBean[] been);
        abstract void getTimelineFailed(TimelineFollowBean bean);
        abstract void getTimelineNoMore(TimelineFollowBean bean);
    }
}
