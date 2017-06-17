package cn.sportstory.android.common.tools;

import android.content.Context;

import java.util.Locale;

/**
 * Created by aaron on 2017/6/17.
 * 设备/系统环境工具类
 */


public class Environment {

    /**
     * 判断设备语言是不是中文
     * @param context
     * @return
     */
    public static boolean isZh(Context context){
        return language(context).endsWith("zh");
    }

    /**
     * 获取系统语言
     * @param context
     * @return
     */
    public static String language(Context context){
        Context ctx = context.getApplicationContext();
        Locale locale = ctx.getResources().getConfiguration().locale;
        return locale.getLanguage();
    }

}
