package cn.sportstory.android.ui.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Tamas on 2017/7/16.
 * <p>
 * 自定义ViewPager  取消了切换Fragment时的动画，用户也可以自己定义是否可以滑动
 */

public class CustomViewPager extends ViewPager {
    private boolean isNoScroll=false;
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, false);//表示切换的时候，不需要切换时间。
    }
    public void setNoScroll(boolean isNoScroll){
        this.isNoScroll=isNoScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        if (isNoScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (isNoScroll)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }
}
