package cn.sportstory.android.chat.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aaron on 2017/4/29.
 * 聊天界面Adapter
 */

public class ChatListRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ChatListViewTextLeftHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public TextView textView;

        public ChatListViewTextLeftHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ChatListViewTextRightHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public TextView textView;

        public ChatListViewTextRightHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ChatListViewImgLeftHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public ImageView imageView;
        public Context context;

        public ChatListViewImgLeftHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
        }
    }

    public static class ChatListViewImgRightHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public ImageView imageView;
        public Context context;

        public ChatListViewImgRightHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
        }
    }

}
