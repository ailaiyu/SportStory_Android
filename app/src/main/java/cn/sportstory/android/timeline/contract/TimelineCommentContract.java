package cn.sportstory.android.timeline.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.common.bean.TimelineCommentBean;

/**
 * Created by aaron on 2017/5/28.
 */

public interface TimelineCommentContract {

    abstract public class Presenter implements BasePresenter{

    }

    abstract class View extends BaseView<Presenter> {
        abstract public void commentSuccess(TimelineCommentBean bean);
        abstract public void commentFailed(TimelineCommentBean bean);
    }
}
