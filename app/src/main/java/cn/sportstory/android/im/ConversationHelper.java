package cn.sportstory.android.im;

import java.util.List;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/**
 * Created by aaron on 2017/4/26.
 * 发送消息，获取消息未读数
 */

public class ConversationHelper {

    /**
     * 获取总消息未读数
     */
    public static void getTotalUnreadCount(){
        RongIMClient.getInstance().getTotalUnreadCount(new RongIMClient.ResultCallback<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                // TODO: 2017/4/26 更新UI integer就是未读数 
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                // TODO: 2017/4/26 获取未读数失败
            }
        });
    }

    /**
     * 根据会话id获取未读数
     * @param type
     * @param targetId
     */
    public static void getUnreadCountByTarget(Conversation.ConversationType type, String targetId){
        RongIMClient.getInstance().getUnreadCount(type, targetId, new RongIMClient.ResultCallback<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                // TODO: 2017/4/26 某个回话未读数 integer
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                // TODO: 2017/4/26 获取未读数失败
            }
        });
    }

    public static void getUnreadCountByConversationType(Conversation.ConversationType type){
        RongIMClient.getInstance().getUnreadCount(new RongIMClient.ResultCallback<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                // TODO: 2017/4/26 这一种会话类型未读消息数 
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                // TODO: 2017/4/26 获取失败
            }
        }, type);
    }


    /**
     * 根据会话id 清除所有未读消息
     * @param type
     * @param targetId
     */
    public static void clearMessageUnreadStatus(Conversation.ConversationType type, String targetId){
        RongIMClient.getInstance().clearMessagesUnreadStatus(type, targetId, new RongIMClient.ResultCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                // TODO: 2017/4/26 操作结果
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

            }
        });
    }

    /**
     * 获取本地存储的会话列表
     */
    public static void getLocalConversationList(){
        RongIMClient.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() {
            @Override
            public void onSuccess(List<Conversation> conversations) {
                // TODO: 2017/4/26 本地缓存会话列表 conversations 
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                // TODO: 2017/4/26 获取失败
            }
        });
    }
}
