package cn.sportstory.sportstory.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.sportstory.sportstory.R;
import cn.sportstory.sportstory.customViews.RoundImageView;

/**
 * Created by  Aaron.Zhang on 17-3-29.
 */

public class ChatRecyclerAdapter extends RecyclerView.Adapter <ChatRecyclerAdapter.ChatItemViewHolder>{

    public static class ChatItemViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public RelativeLayout mRlChatItem;
        public RoundImageView mRivAvatar;
        public TextView mTvNickname;
        public TextView mTvMsg;
        public TextView mTvTime;

        public ChatItemViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.mRlChatItem = (RelativeLayout)itemView.findViewById(R.id.rl_chat_item);
            this.mRivAvatar = (RoundImageView)itemView.findViewById(R.id.riv_chat_item_avatar);
            this.mTvNickname = (TextView)itemView.findViewById(R.id.tv_chat_item_nickname);
            this.mTvTime = (TextView) itemView.findViewById(R.id.tv_chat_item_time);
            this.mTvMsg = (TextView) itemView.findViewById(R.id.tv_chat_item_msg);
        }
    }

    @Override
    public ChatItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        ChatItemViewHolder viewHolder = new ChatItemViewHolder(v, parent.getContext());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChatItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
