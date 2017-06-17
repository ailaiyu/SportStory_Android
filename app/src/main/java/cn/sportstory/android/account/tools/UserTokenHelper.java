package cn.sportstory.android.account.tools;

import android.content.Context;
import android.text.TextUtils;

import cn.sportstory.android.SportStoryApp;
import cn.sportstory.android.common.tools.SharedPreferenceHelper;
import cn.sportstory.android.constants.PreferencesConstants;

/**
 * Created by aaron on 2017/6/2.
 */

public class UserTokenHelper {

    public static void updateToken(String token, Context context){
        if (TextUtils.isEmpty(token))
            return;
        SportStoryApp.USER_TOKEN = token;
        SharedPreferenceHelper.writeString(PreferencesConstants.USER_TOKEN, token, PreferencesConstants.ACCOUNT_FILE_NAME, context);

    }

    public static String getToken(Context context) {
        if (TextUtils.isEmpty(SportStoryApp.USER_TOKEN))
            SportStoryApp.USER_TOKEN = SharedPreferenceHelper.getString(PreferencesConstants.USER_TOKEN, PreferencesConstants.ACCOUNT_FILE_NAME, context);
        return SportStoryApp.USER_TOKEN;
    }
}
