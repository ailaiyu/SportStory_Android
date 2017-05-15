package cn.sportstory.android.chat.view;

import android.content.Context;
import android.content.Intent;
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

import cn.sportstory.android.R;
import cn.sportstory.android.chat.bean.ChatItemBean;
import cn.sportstory.android.tools.ImageLoader;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by  Aaron.Zhang on 17-3-29.
 * 会话列表界面adapter
 */

public class ConversationRecyclerAdapter extends RecyclerView.Adapter <ConversationRecyclerAdapter.ChatItemViewHolder>{

    private ArrayList<ChatItemBean> chats;
    private Context context;

    public ConversationRecyclerAdapter(ArrayList<ChatItemBean> chats, Context context) {
        this.chats = new ArrayList<>();
        cloneChats(chats);
        this.context = context.getApplicationContext();
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
        public RelativeLayout mRlChatItem;
        public CircleImageView mRivAvatar;
        public TextView mTvNickname;
        public TextView mTvMsg;
        public TextView mTvTime;
        public String userId;

        public ChatItemViewHolder(View itemView, final Context context) {
            super(itemView);
            this.mRlChatItem = (RelativeLayout)itemView.findViewById(R.id.rl_chat_item);
            this.mRivAvatar = (CircleImageView) itemView.findViewById(R.id.civ_chat_item_avatar);
            this.mTvNickname = (TextView)itemView.findViewById(R.id.tv_chat_item_nickname);
            this.mTvTime = (TextView) itemView.findViewById(R.id.tv_chat_item_time);
            this.mTvMsg = (TextView) itemView.findViewById(R.id.tv_chat_item_msg);

            this.mRlChatItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 2017/4/8 进入聊天界面
                    Intent intent = new Intent();
                    Bundle args = new Bundle();
                    args.putString(ChatActivity.BUNDLE_CHAT_TYPE, ChatActivity.CHAT_TYPE_P2P);
                    args.putString(ChatActivity.BUNDLE_CHAT_TARGET_ID, userId);
                    intent.putExtras(args);
                    intent.setClass(context, ChatActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public ChatItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversation_item, parent, false);
        ChatItemViewHolder viewHolder = new ChatItemViewHolder(v, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ChatItemViewHolder holder, int position) {
        ChatItemBean chatItemBean = chats.get(position);
        holder.mTvMsg.setText(chatItemBean.getMsg());
        holder.mTvTime.setText(chatItemBean.getTime());
        holder.mTvNickname.setText(chatItemBean.getNickname());
        ImageLoader.displayImage(chatItemBean.getAvatarPath(), holder.mRivAvatar, context);
        holder.userId = chatItemBean.getUserId();
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
                        ImageLoader.displayImage(bundle.getString(key), holder.mRivAvatar, context);
                        break;
                    case "nickname":
                        holder.mTvNickname.setText(bundle.getString(key));
                        break;
                    case "time":
                        holder.mTvTime.setText(bundle.getString(key));
                        break;
                    case "msg":
                        holder.mTvMsg.setText(bundle.getString(key));
                        break;
                    case "userId":
                        holder.userId = bundle.getString(key);
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
