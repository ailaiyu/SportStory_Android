package cn.sportstory.android.common.tools;

import android.content.Context;

/**
 * Created by aaron on 2017/6/19.
 */

public class ViewUtils {

    public static float dipToPx(Context context, float value){
        float density = context.getResources().getDisplayMetrics().density;
        return value * density;
    }

    public static float pxToDip(Context context, float value){
        float density = context.getResources().getDisplayMetrics().density;
        return value / density;

    }

}
