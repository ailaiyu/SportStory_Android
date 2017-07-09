package cn.sportstory.android.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Tamas on 2017/2/20.
 * 支持点击事件的RecyclerViewAdapter
 */

public abstract class BaseRvAdapter extends RecyclerView.Adapter<BaseRvAdapter.BaseRvViewHolder> {

    private static long mLastClickeTimeStamp=0;

    private MyItemClickListener mItemClickListener;

    private MyItemLongClickListener mItemLongClickListener;

    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public void setItemLongClickListener(MyItemLongClickListener mItemLongClickListener) {
        this.mItemLongClickListener = mItemLongClickListener;
    }
    @Override
    public abstract BaseRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(BaseRvViewHolder holder, int position);

    @Override
    public abstract int getItemCount();

    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
    public interface MyItemLongClickListener{
        boolean onItemLongClick(View view, int position);
    }

    public  class BaseRvViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener,View.OnLongClickListener{

        public BaseRvViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if( mItemClickListener== null) return;
            long currentTimeStamp= System.currentTimeMillis();
            //消除抖动
            if(currentTimeStamp-mLastClickeTimeStamp>30){
                mLastClickeTimeStamp=currentTimeStamp;
                mItemClickListener.onItemClick(v,getPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (mItemLongClickListener == null) return false;

            return mItemLongClickListener.onItemLongClick(v,getPosition());
        }
    }
}
