package cn.sportstory.android.common.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaron on 2017/5/20.
 */

public class TextCheckUtil {

    public static final String REGEX_EMAIL =
            "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static final String REGEX_MOBILE =
            "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    public static boolean IsPhone(String phone){
        if (phone == null){
            return false;
        }
        return Pattern.matches(REGEX_MOBILE, phone);
    }

    public static boolean IsEmail(String email){

        if (email == null)
            return false;
        return Pattern.matches(REGEX_EMAIL, email);
    }
}
