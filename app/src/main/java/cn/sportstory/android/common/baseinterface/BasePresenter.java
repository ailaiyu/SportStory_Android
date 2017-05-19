package cn.sportstory.android.common.baseinterface;

import cn.sportstory.android.common.bean.CommonBean;

/**
 * Created by aaron on 2017/5/17.
 */

public interface BasePresenter {
    void doTask();
    void setupTask(CommonBean bean, BaseView view);
}
