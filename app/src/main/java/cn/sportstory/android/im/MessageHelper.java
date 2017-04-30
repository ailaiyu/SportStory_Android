package cn.sportstory.android.im;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.observers.TestObserver;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
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
     *
     */
    public static void sendTextMessage(Conversation.ConversationType type, String targetId,
                                       String messageContent, String pushContent, String pushData){
        RongIMClient.getInstance().sendMessage(type, targetId, TextMessage.obtain(messageContent),
                pushContent, pushData, new RongIMClient.SendMessageCallback(){
                    //发送消息的回调
                    @Override
                    public void onError(Integer integer, RongIMClient.ErrorCode errorCode) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {

                    }
                },new RongIMClient.ResultCallback<Message>() {
                    //消息库存的回调， 可以用于获取消息实体
                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {

                    }

                    @Override
                    public void onSuccess(Message message) {

                    }

                });
    }

    /**
     * 发送图片消息
     * @param imgPath 图片路径
     * @param context 上下文
     * @param imgMsg 消息内容
     * @param type 消息类型
     * @param targetId 会话id
     * @param pushContent 对方接收离线消息时需要显示的push消息内容
     * @param pushData 对方离线时需要在push消息中携带的非显示内容
     */
    public static void sendImageMessage(String imgPath, Context context, MessageContent imgMsg,
                                        Conversation.ConversationType type, String targetId,
                                        String pushContent, String pushData){
        Context ctx = context.getApplicationContext();
        File imageSource = new File(ctx.getCacheDir(), "source.jpg");
        File imageThumb = new File(ctx.getCacheDir(), "thumb.jpg");
        try {
            InputStream is = ctx.getAssets().open(imgPath);
            Bitmap bmpSource = BitmapFactory.decodeStream(is);
            imageSource.createNewFile();
            FileOutputStream os = new FileOutputStream(imageSource);
            //保存原图
            bmpSource.compress(Bitmap.CompressFormat.JPEG, 100, os);
            //创建缩略图变换矩阵
            Matrix m = new Matrix();
            m.setRectToRect(new RectF(0,0,bmpSource.getWidth(), bmpSource.getHeight()),
                    new RectF(0,0,160,160), Matrix.ScaleToFit.CENTER);
            //创建缩略图
            Bitmap bmpThumb = Bitmap.createBitmap(bmpSource, 0,0,bmpSource.getWidth(),
                    bmpSource.getHeight(), m, true );
            imageThumb.createNewFile();
            FileOutputStream osThumb = new FileOutputStream(imageThumb);
            //保存缩略图
            bmpThumb.compress(Bitmap.CompressFormat.JPEG, 60, osThumb);
        }catch (IOException e){
            e.printStackTrace();
            // TODO: 2017/4/27 发送失败，如何处理
        }

        //发送图片消息
        RongIMClient.getInstance().sendImageMessage(type, targetId, imgMsg, pushContent, pushData,
                new RongIMClient.SendImageMessageCallback() {
                    //发送消息的回调
                    @Override
                    public void onAttached(Message message) {

                    }

                    @Override
                    public void onError(Message message, RongIMClient.ErrorCode errorCode) {

                    }

                    @Override
                    public void onSuccess(Message message) {

                    }

                    @Override
                    public void onProgress(Message message, int i) {

                    }
                });


    }
}
