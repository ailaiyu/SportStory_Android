package cn.sportstory.android.common.tools;

import android.text.TextUtils;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaron on 2017/5/20.
 */

public class TextCheckUtil {

    private static final String REGEX_EMAIL =
            "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    private static final String REGEX_MOBILE =
            "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    public static boolean IsPhone(String phone){
        return !TextUtils.isEmpty(phone) && Pattern.matches(REGEX_MOBILE, phone);
    }

    public static boolean IsEmail(String email){
        return !TextUtils.isEmpty(email) && Pattern.matches(REGEX_EMAIL, email);
    }
}
