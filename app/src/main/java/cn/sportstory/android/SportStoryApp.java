package cn.sportstory.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.squareup.leakcanary.LeakCanary;
import com.umeng.analytics.MobclickAgent;

import cn.jpush.android.api.JPushInterface;
import cn.sportstory.android.account.tools.UserTokenHelper;
import cn.sportstory.android.chat.customeMessageType.LocalTipMessage;
import cn.sportstory.android.common.tools.SharedPreferenceHelper;
import io.rong.imlib.AnnotationNotFoundException;
import io.rong.imlib.RongIMClient;

/**
 * Created by aaron on 2017/4/8.
 * application 初始化IM, PUSH ..
 */
public class SportStoryApp extends Application {

    public static int sActivityCount = 0;

    public static String USER_TOKEN = "";
    public static String USER_ID = "";

    @Override
    public void onCreate() {
        super.onCreate();

        if(LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        /**
         * OnCreate函数会被多个进程进入
         * 这段保护代码确保只有RongIMCient的进程和push进程执行了init
         * io.rong.push为融云push进程名
         */
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))
                || "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {
//            RongIMClient.init(this);
            try {
                // 注册融云自定义消息类型， 在init之后立即注册
                RongIMClient.registerMessageType(LocalTipMessage.class);
            }catch (AnnotationNotFoundException e){
                e.printStackTrace();
            }
        }

        try {
            //配置APM信息
            ApplicationInfo applicationInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            MobclickAgent.UMAnalyticsConfig config = new MobclickAgent.
                    UMAnalyticsConfig(getApplicationContext(),
                    applicationInfo.metaData.getString("UMENG_APPKEY"),
                    applicationInfo.metaData.getString("UMENG_CHANNEL"));
            MobclickAgent.startWithConfigure(config);
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }

        //初始化极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

    }

    /**
     * 获取当前进程的进程名
     * @param context 应该使用Application的Context， 避免内存泄漏
     * @return
     */
    public static String getCurProcessName(Context context){
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager)context.
                getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcessInfo :
                activityManager.getRunningAppProcesses()) {
            if (appProcessInfo.pid == pid)
                return appProcessInfo.processName;
        }
        return null;
    }



}
