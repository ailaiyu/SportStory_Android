package cn.sportstory.android.ui.base;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Tamas on 2017/7/10.
 */

public class CustomGridLayoutManager extends GridLayoutManager {
    private boolean isScrollEnabled=true;

    public CustomGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}