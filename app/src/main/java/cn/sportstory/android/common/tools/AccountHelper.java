package cn.sportstory.android.common.tools;

import android.content.Context;

import cn.sportstory.android.constants.PreferencesConstants;

/**
 * Created by aaron on 2017/6/19.
 */

public class AccountHelper {
    public final static String LOGIN_YES = "login";
    public final static String LOGIN_NO = "logout";
    public final static String ACTION_LOGOUT = "cn.sportstory.android.common.tools.AccountHelper.Logout";
    public static boolean isLogin(Context context) {
        String login = SharedPreferenceHelper.getString(PreferencesConstants.LOGIN_STATUS, PreferencesConstants.ACCOUNT_FILE_NAME, context);
        return login != null && login.equals(LOGIN_YES);
    }
    public static void changeLoginStatus(Context context, boolean login){
        if (login)
            SharedPreferenceHelper.writeString(PreferencesConstants.LOGIN_STATUS, LOGIN_YES, PreferencesConstants.ACCOUNT_FILE_NAME, context);
        else
            SharedPreferenceHelper.writeString(PreferencesConstants.LOGIN_STATUS, LOGIN_NO, PreferencesConstants.ACCOUNT_FILE_NAME, context);
    }
}
