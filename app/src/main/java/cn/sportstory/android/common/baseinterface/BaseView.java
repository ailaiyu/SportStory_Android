package cn.sportstory.android.common.baseinterface;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/17.
 */

public abstract class BaseView<T> {

    public abstract Context getViewContext();
    public void showError(String error){
        Context context = getViewContext();
        if (context != null) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
        }
    }

    public void showNetDisconnect(){
        Context context = getViewContext();
        if (context != null)
            Toast.makeText(context, context.getString(R.string.net_disconnect), Toast.LENGTH_SHORT).show();
    }
    //服务器错误
    protected  void showServerError(){
        Context context = getViewContext();
        if (context != null)
            Toast.makeText(context, context.getString(R.string.server_error), Toast.LENGTH_SHORT).show();
    }

}
