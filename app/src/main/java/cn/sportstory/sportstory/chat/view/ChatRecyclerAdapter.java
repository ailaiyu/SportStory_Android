package cn.sportstory.sportstory.chat.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.sportstory.sportstory.R;
import cn.sportstory.sportstory.chat.bean.ChatItemBean;
import cn.sportstory.sportstory.customViews.RoundImageView;

/**
 * Created by  Aaron.Zhang on 17-3-29.
 */

public class ChatRecyclerAdapter extends RecyclerView.Adapter <ChatRecyclerAdapter.ChatItemViewHolder>{

    private ArrayList<ChatItemBean> chats;
    private Context context;

    public ChatRecyclerAdapter(ArrayList<ChatItemBean> chats, Context context) {
        this.chats = new ArrayList<>();
        cloneChats(chats);
        this.context = context;
    }

    public ArrayList<ChatItemBean> getChats() {
        return chats;
    }

    public void setChats(ArrayList<ChatItemBean> chats){
        cloneChats(chats);
    }

    private void cloneChats(ArrayList<ChatItemBean> newChats){
        chats.clear();
        if (!newChats.isEmpty())
        {
            for (int i = 0; i < newChats.size(); i ++)
            {
                ChatItemBean bean = new ChatItemBean();
                bean.setUserId(newChats.get(i).getUserId());
                bean.setNickname(newChats.get(i).getNickname());
                bean.setAvatarPath(newChats.get(i).getAvatarPath());
                bean.setMsg(newChats.get(i).getMsg());
                bean.setTime(newChats.get(i).getTime());
                chats.add(bean);
            }
        }
    }

    public static class ChatItemViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public RelativeLayout mRlChatItem;
        public RoundImageView mRivAvatar;
        public TextView mTvNickname;
        public TextView mTvMsg;
        public TextView mTvTime;


        public ChatItemViewHolder(View itemView, final Context context) {
            super(itemView);
            this.context = context;
            this.mRlChatItem = (RelativeLayout)itemView.findViewById(R.id.rl_chat_item);
            this.mRivAvatar = (RoundImageView)itemView.findViewById(R.id.riv_chat_item_avatar);
            this.mTvNickname = (TextView)itemView.findViewById(R.id.tv_chat_item_nickname);
            this.mTvTime = (TextView) itemView.findViewById(R.id.tv_chat_item_time);
            this.mTvMsg = (TextView) itemView.findViewById(R.id.tv_chat_item_msg);

            this.mRlChatItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "你点击了和" + mTvNickname.getText().toString() + "的对话", Toast.LENGTH_SHORT ).show();
                }
            });
        }
    }

    @Override
    public ChatItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        ChatItemViewHolder viewHolder = new ChatItemViewHolder(v, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChatItemViewHolder holder, int position) {
        ChatItemBean chatItemBean = chats.get(position);
        holder.mTvMsg.setText(chatItemBean.getMsg());
        holder.mTvTime.setText(chatItemBean.getTime());
        holder.mTvNickname.setText(chatItemBean.getNickname());

    }

    @Override
    public void onBindViewHolder(ChatItemViewHolder holder, int position, List<Object> payloads) {
        if (payloads.isEmpty())
            onBindViewHolder(holder, position);
        else {
            Bundle bundle = (Bundle) payloads.get(0);
            for (String key: bundle.keySet()){
                switch (key){
                    case "avatarPath":
                        break;
                    case "nickname":
                        holder.mTvNickname.setText((CharSequence) bundle.get(key));
                        break;
                    case "time":
                        holder.mTvTime.setText((CharSequence) bundle.get(key));
                        break;
                    case "msg":
                        holder.mTvMsg.setText((CharSequence) bundle.get(key));
                        break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if (chats == null)
            return 0;
        return chats.size();
    }
}
