package cn.sportstory.android.ui.base;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by Tamas on 2017/7/10.
 */

public class CustomLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;


    public CustomLinearLayoutManager(Context context,int oritation) {
        super(context,oritation,false);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}