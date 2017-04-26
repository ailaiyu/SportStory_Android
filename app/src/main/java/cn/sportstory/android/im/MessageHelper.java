package cn.sportstory.android.im;

import io.reactivex.observers.TestObserver;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;

/**
 * Created by aaron on 2017/4/26.
 * 消息助手，发送文字消息，图片消息，本地消息等
 */

public class MessageHelper {

    /**
     * 发送普通消息
     *
     * @param type                      会话类型
     * @param targetId                  会话ID
     * @param messageContent            消息的内容，一般是MessageContent的子类对象
     * @param pushContent               接收方离线时需要显示的push消息内容
     * @param pushData                  接收方离线时需要在push消息中携带的非显示内容
     * @param SendImageMessageCallback  发送消息的回调
     * @param ResultCallback            消息存库的回调，可用于获取消息实体
     *
     */
    public static void sendTextMessage(Conversation.ConversationType type, String targetId,
                                       String messageContent, String pushContent, String pushData){
        RongIMClient.getInstance().sendMessage(type, targetId, TextMessage.obtain(messageContent),
                pushContent, pushData, new RongIMClient.SendMessageCallback(){
                    @Override
                    public void onError(Integer integer, RongIMClient.ErrorCode errorCode) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {

                    }
                },new RongIMClient.ResultCallback<Message>() {
                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {

                    }

                    @Override
                    public void onSuccess(Message message) {

                    }

                });
    }
}
