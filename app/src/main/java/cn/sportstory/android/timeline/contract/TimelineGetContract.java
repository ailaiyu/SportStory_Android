package cn.sportstory.android.timeline.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.TimelineGetBean;

/**
 * Created by aaron on 2017/5/21.
 */

public interface TimelineGetContract {
    abstract class Presenter implements BasePresenter{}

    abstract class View extends BaseView<Presenter>{
        abstract void getTimelineSuccess(TimelineGetBean[] been);
        abstract void getTimelineFailed(TimelineGetBean bean);
        abstract void getTimelineNoMore(TimelineGetBean bean);
    }
}
