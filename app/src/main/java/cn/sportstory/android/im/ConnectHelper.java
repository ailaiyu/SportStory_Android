package cn.sportstory.android.im;

import android.content.Context;

import cn.sportstory.android.SportStoryApp;
import io.rong.imlib.RongIMClient;

/**
 * Created by aaron on 2017/4/26.
 * 融云IM模块登录、退出、重连类
 */

public class ConnectHelper {

    /**
     * 连接融云服务器
     * 只需要在最开始连接一次服务器，sdk会自动负责断开重连的操作
     * @param context activity
     * @param token 从Server API 获取到的token
     */
    public static void connect (Context context, String token){

        if (context.getApplicationContext().getApplicationInfo().packageName
                .equals(SportStoryApp.getCurProcessName(context.getApplicationContext()))){
            RongIMClient.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * token错误，主要是因为Token已经过期，需要向App Server请求一个新的token
                 */
                @Override
                public void onTokenIncorrect() {
                    // TODO: 2017/4/26 向App Server 请求新的token
                }

                @Override
                public void onSuccess(String s) {
                    // TODO: 2017/4/26 连接成功
                }

                /**
                 * 连接失败
                 * @param errorCode
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    // TODO: 2017/4/26 去官网查看errorCode对应的错误码。做相应处理
                }
            });
        }
    }
}
