package cn.sportstory.android.im;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;

/**
 * Created by aaron on 2017/4/26.
 * 新消息监听器
 */

public class IMMessageReceiveListener implements RongIMClient.OnReceiveMessageListener {

    /**
     * 接收到新消息
     * @param message 收到的消息实体
     * @param left 剩余未拉取消息数目
     * @return
     */
    @Override
    public boolean onReceived(Message message, int left) {
        return false;
    }
}
