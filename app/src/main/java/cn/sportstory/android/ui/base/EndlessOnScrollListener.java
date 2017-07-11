package cn.sportstory.android.ui.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by Tamas on 2017/7/10.
 */

public abstract class EndlessOnScrollListener extends  RecyclerView.OnScrollListener{

    private static final String  TAG=EndlessOnScrollListener.class.getName();

    //声明一个LinearLayoutManager
    private LinearLayoutManager mLinearLayoutManager;

    //当前页，从0开始    private int currentPage = 0;
    //已经加载出来的Item的数量
    private int totalItemCount;

    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;

    //在屏幕上可见的item数量
    private int visibleItemCount;

    //在屏幕可见的Item中的第一个
    private int firstVisibleItem;

    //是否正在上拉数据
    private boolean loading = true;

    int currentPage;

    public EndlessOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);


        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        if(loading){
            /*
            Log.d(TAG,"firstVisibleItem: " +firstVisibleItem);
            Log.d(TAG,"totalPageCount:" +totalItemCount);
            Log.d(TAG, "visibleItemCount:" + visibleItemCount);
            */

            if(totalItemCount == previousTotal){
                Log.i(TAG,"加载结束");
                //说明数据已经加载结束
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if(totalItemCount-visibleItemCount <= firstVisibleItem){
            Log.i(TAG,"呵呵");
        }
        //这里需要好好理解
        if (!loading && totalItemCount-visibleItemCount <= firstVisibleItem){
            Log.i(TAG,"哈哈哈");
            currentPage ++;
            onLoadMore(currentPage);
            loading = true;
        }else{
            Log.i(TAG,"DDDD");
        }
    }

    /**
     * 提供一个抽闲方法，在Activity中监听到这个EndLessOnScrollListener
     * 并且实现这个方法
     * */
    public abstract void onLoadMore(int currentPage);
}