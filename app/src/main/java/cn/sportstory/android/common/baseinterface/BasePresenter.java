package cn.sportstory.android.common.baseinterface;

import android.content.Context;

import cn.sportstory.android.common.bean.CommonBean;

/**
 * Created by aaron on 2017/5/17.
 */

public abstract class BasePresenter {
    public BaseView view;

    public BasePresenter(BaseView baseView) {
        this.view = baseView;
    }

    public abstract void doTask();
    public abstract void setupTask(CommonBean bean);
    public Context getContext(){
        return view.getViewContext();
    }
}
