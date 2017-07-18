package cn.sportstory.android.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Tamas on 2016/11/28.
 */

public class NotifyUtil {
    public static void  showSnackMsg(View view, String msg){
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
