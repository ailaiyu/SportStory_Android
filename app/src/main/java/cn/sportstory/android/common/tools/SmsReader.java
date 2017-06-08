package cn.sportstory.android.common.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaron on 2017/6/6.
 * 读取手机短信验证码
 */

public class SmsReader extends BroadcastReceiver {
    private static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    private static final int VCODE_LENGTH = 4;
    private String SMS_VCODE_TITLE_CHINESE = "【运动故事】";
    private String SMS_VCODE_TITLE_ENGLISH = "[Sport Story]";
    private static final String VCODE_REGEX = "[0-9\\.]+";

    private String smsContent = null;
    @Override
    public void onReceive(Context context, Intent intent) {
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
     * @return 验证码
     */
    private String getVCode(){
        if (TextUtils.isEmpty(smsContent) ||
                (!smsContent.startsWith(SMS_VCODE_TITLE_ENGLISH) &&
                !smsContent.startsWith(SMS_VCODE_TITLE_CHINESE)))
            return null;
        else {
            Pattern pattern = Pattern.compile(VCODE_REGEX);
            Matcher m = pattern.matcher(smsContent);
            String dynamicPassword = "";
            while(m.find()){
                if(m.group().length() == VCODE_LENGTH) {
                    System.out.print(m.group());
                    dynamicPassword = m.group();
                }
            }
            return dynamicPassword;
        }
    }
}
