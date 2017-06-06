package cn.sportstory.android.common.tools;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.TextUtils;

/**
 * Created by aaron on 2017/6/6.
 * 读取手机短信验证码
 */

public class SmsReader extends BroadcastReceiver {
    private static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";


    @Override
    public void onReceive(Context context, Intent intent) {
        String smsContent = null;
        String action = intent.getAction();
        //判断广播消息
        if (action.equals(SMS_RECEIVED_ACTION)) {
            Bundle bundle = intent.getExtras();
            //如果不为空
            if (bundle != null) {
                //将pdus里面的内容转化成Object[]数组
                Object pdusData[] = (Object[]) bundle.get("pdus");
                //解析短信
                if (pdusData != null) {
                    SmsMessage[] msg = new SmsMessage[pdusData.length];
                    for (int i = 0; i < msg.length; i++) {
                        byte pdus[] = (byte[]) pdusData[i];
                        msg[i] = SmsMessage.createFromPdu(pdus);
                    }
                    StringBuilder content = new StringBuilder();
                    for (SmsMessage temp : msg) {
                        content.append(temp.getMessageBody());
                    }
                    smsContent = content.toString();
                }
            }
        }
    }

    /**
     * 从短信中解析验证码
     * @param smsContent 短信内容
     * @return 验证码
     */
    private String getVcode(String smsContent){

        if (TextUtils.isEmpty(smsContent))
            return null;
        else
            // TODO: 2017/6/6 解析短信
            return "";
    }
}
