package cn.sportstory.android.chat.view;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.ArrayList;
import java.util.List;

import io.rong.imlib.model.Message;

/**
 * Created by aaron on 2017/5/5.
 * 聊天内容对比callback
 */

public class ChatListCallback extends DiffUtil.Callback {
    ArrayList<Message> newMessage, oldMessage;

    public ChatListCallback(ArrayList<Message> newMessage, ArrayList<Message> oldMessage) {
        this.newMessage = newMessage;
        this.oldMessage = oldMessage;
    }

    public ChatListCallback() {
        super();
    }



    @Override
    public int getOldListSize() {
        return oldMessage == null ? 0 : oldMessage.size();
    }

    @Override
    public int getNewListSize() {
        return newMessage == null ? 0 : newMessage.size();
    }

    /**
     * 判断两个消息是否id一致
     *
     * -------------2017/05/05(Aaron.Zhang)--------
     * 这个地方有点奇怪啊，消息id是在发送之前就生成了还是发送成功之后才生成？？
     * 如果发送成功之前，之后消息id不变，那么消息状态实际上发生了变化，这里却返回了true.
     *
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Message oldMsg = oldMessage.get(oldItemPosition);
        Message newMsg = newMessage.get(newItemPosition);
        if (oldMsg == null || newMsg == null)
            return false;
        return oldMsg.getMessageId() == newMsg.getMessageId();
    }

    /**
     * 如果消息id一致，则判断消息内部内容是否一致
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Message oldMsg = oldMessage.get(oldItemPosition);
        Message newMsg = newMessage.get(newItemPosition);
        if (oldMsg == null || newMsg == null)
            return true;
        return false;
    }

    /**
     * 获取新老消息差异集
     *
     * ------------2017/05/05(Aaron.Zhang)--------
     * 现在还没有必要来写这个方法
     * 原因如下:
     * 1:尚未了解Message消息体内部机制，获取差异集比较麻烦
     * 2:在业务场景中，只有同一条消息的内容发发生了变化才会调用这个方法，但是聊天内容目前没有发生改变的可能性
     *  （试想一下，发送给对方的消息，发送成功之后消息内容发生了变化？？？）
     *
     * ------------2017/05/06(Aaron.Zhang)---------
     * 是需要写这个函数的
     * 因为，消息的发送成功状态是会发生变化的，比如：发送成功之前，应该显示一个加载icon，
     * 发送成功就取消icon，发送失败显示一个红色的惊叹号
     *
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // TODO: 2017/5/5 比较新旧两条消息，获取差异集
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
