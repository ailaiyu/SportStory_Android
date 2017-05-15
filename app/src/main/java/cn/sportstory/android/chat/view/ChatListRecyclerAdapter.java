package cn.sportstory.android.chat.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.sportstory.android.R;
import cn.sportstory.android.chat.customeMessageType.LocalTipMessage;
import cn.sportstory.android.tools.ImageLoader;
import de.hdodenhof.circleimageview.CircleImageView;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.message.ImageMessage;
import io.rong.message.TextMessage;

/**
 * Created by aaron on 2017/4/29.
 * 聊天界面Adapter
 */

public class ChatListRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Message> messages;
    private Context context;
    private static final int VIEW_TYPE_UNKNOWN = 0;
    private static final int VIEW_TYPE_TEXT_LEFT = 1;
    private static final int VIEW_TYPE_TEXT_RIGHT = 2;
    private static final int VIEW_TYPE_IMG_LEFT = 3;
    private static final int VIEW_TYPE_IMG_RIGHT = 4;
    private static final int VIEW_TYPE_LOCAL = 5;

    public ChatListRecyclerAdapter(ArrayList<Message> messages, Context context) {
        this.messages = messages;
        this.context = context.getApplicationContext();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        View v;
        switch (viewType)
        {
            case VIEW_TYPE_TEXT_LEFT:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_left_text, parent, false);
                holder = new ChatListViewTextLeftHolder(v, context);
                return holder;
            case VIEW_TYPE_TEXT_RIGHT:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_right_text, parent, false);
                holder = new ChatListViewTextRightHolder(v, context);
                return holder;
            case VIEW_TYPE_IMG_LEFT:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_left_img, parent, false);
                holder = new ChatListViewImgLeftHolder(v, context);
                return holder;
            case VIEW_TYPE_IMG_RIGHT:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_right_img, parent, false);
                holder = new ChatListViewImgRightHolder(v, context);
                return holder;
            case VIEW_TYPE_LOCAL:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_local, parent, false);
                holder = new ChatListViewTipViewHolder(v, context);
                return holder;
            case VIEW_TYPE_UNKNOWN:
                return null;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        MessageContent content = message.getContent();
        if (content instanceof TextMessage)
        {
            if (message.getSenderUserId().equals(RongIMClient.getInstance().getCurrentUserId()))
            {
                return VIEW_TYPE_TEXT_RIGHT;
            }else{
                return VIEW_TYPE_TEXT_LEFT;
            }
        }else if (content instanceof ImageMessage)
        {
            if (message.getSenderUserId().equals(RongIMClient.getInstance().getCurrentUserId())) {
                return VIEW_TYPE_IMG_RIGHT;
            }
            else {
                return VIEW_TYPE_IMG_LEFT;
            }

        }else if (content instanceof LocalTipMessage)
        {
            return VIEW_TYPE_LOCAL;
        }else
            return VIEW_TYPE_UNKNOWN;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);
        if (message.getContent() instanceof TextMessage){
            //文字消息
            if (message.getSenderUserId().equals(RongIMClient.getInstance().getCurrentUserId()))
            {
                //我发出的消息
                ((ChatListViewTextRightHolder) holder).textView.setText(((TextMessage) message.getContent()).getContent());
                ImageLoader.getInstance().displayImage(message.getContent().getUserInfo().getPortraitUri(),
                        ((ChatListViewTextRightHolder) holder).avatar, context);
            }else
            {
                //我接收的消息
                ((ChatListViewTextLeftHolder) holder).textView.setText(((TextMessage) message.getContent()).getContent());
                ImageLoader.getInstance().displayImage(message.getContent().getUserInfo().getPortraitUri(),
                        ((ChatListViewTextLeftHolder) holder).avatar, context);
            }
        }else if (message.getContent() instanceof ImageMessage)
        {
            //图片消息类型
            if (message.getSenderUserId().equals(RongIMClient.getInstance().getCurrentUserId()))
            {
                //自己发送的消息
                ImageLoader.getInstance().displayImage(message.getContent().getUserInfo().getPortraitUri(),
                        ((ChatListViewImgRightHolder) holder).avatar, context);
                ImageLoader.getInstance().displayImage(((ImageMessage) message.getContent()).getThumUri(),
                        ((ChatListViewImgRightHolder) holder).avatar, context);
            }else {
                //自己接收的消息
                ImageLoader.getInstance().displayImage(message.getContent().getUserInfo().getPortraitUri(),
                        ((ChatListViewImgLeftHolder) holder).avatar, context);
                ImageLoader.getInstance().displayImage(((ImageMessage) message.getContent()).getThumUri(),
                        ((ChatListViewImgLeftHolder) holder).avatar, context);
            }
        }else if (message.getContent() instanceof LocalTipMessage){
            ((ChatListViewTipViewHolder)holder).textView.setText(((LocalTipMessage) message.getContent()).getContent());
        }else {
            //其他消息类型，目前版本还没有
        }

    }

    @Override
    public int getItemCount() {
        if (messages == null)
            return 0;
        return messages.size();
    }

    /**
     * 接收到的文字消息viewholder
     */
    private class ChatListViewTextLeftHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public TextView textView;
        public Context context;

        public ChatListViewTextLeftHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.avatar = (CircleImageView)itemView.findViewById(R.id.img_chat_img_left_avatar);
            this.textView = (TextView) itemView.findViewById(R.id.text_chat_text_left_text);
            this.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            this.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }
    }

    /**
     * 我发送的文字消息viewholder
     */
    private class ChatListViewTextRightHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public TextView textView;
        public Context context;

        public ChatListViewTextRightHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.avatar = (CircleImageView) itemView.findViewById(R.id.img_chat_text_right_avatar);
            this.textView = (TextView) itemView.findViewById(R.id.tv_chat_text_right_text);
            this.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // TODO: 2017/4/30 长按
                    return false;
                }
            });
            this.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2017/4/30 点击
                }
            });
        }
    }

    /**
     * 接收到的图片消息viewholder
     */
    private class ChatListViewImgLeftHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public TextView textView;
        public Context context;

        public ChatListViewImgLeftHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.avatar = (CircleImageView)itemView.findViewById(R.id.img_chat_text_left_avatar);
            this.textView = (TextView)itemView.findViewById(R.id.text_chat_text_left_text);
            this.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // TODO: 2017/4/30 长按
                    return false;
                }
            });
            this.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2017/4/30 点击 
                }
            });
        }
    }

    /**
     * 聊天消息
     */
    private class ChatListViewImgRightHolder extends RecyclerView.ViewHolder{
        public CircleImageView avatar;
        public ImageView imageView;
        public Context context;

        public ChatListViewImgRightHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.avatar = (CircleImageView)itemView.findViewById(R.id.img_chat_img_right_avatar);
            this.imageView = (ImageView)itemView.findViewById(R.id.img_chat_img_right_imageview);
            this.imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //长按消息
                    return false;
                }
            });

            this.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击消息
                }
            });
        }
    }

    /**
     * 提示消息viewholder
     */
    private class ChatListViewTipViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public TextView textView;

        public ChatListViewTipViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            this.textView = (TextView)itemView.findViewById(R.id.text_chat_local_tip);
        }
    }



}
