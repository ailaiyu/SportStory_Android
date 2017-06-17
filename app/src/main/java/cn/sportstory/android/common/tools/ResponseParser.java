package cn.sportstory.android.common.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import cn.sportstory.android.R;
import cn.sportstory.android.account.tools.UserTokenHelper;
import cn.sportstory.android.account.view.LoginActivity;
import cn.sportstory.android.common.bean.CommonBean;
import retrofit2.Response;

/**
 * Created by aaron on 2017/6/17.
 */

public class ResponseParser {

    private static final int TOKEN_OVERDUE = 401;
    public static final int RESPONSE_ERR = 400;
    public static void parseResponse(Response response, Context context){
        if (context == null)
            return;
        Context ctx = context.getApplicationContext();
        String token = response.headers().get("token");
        if (!TextUtils.isEmpty(token)) {
            UserTokenHelper.updateToken(token, context);
        }
        int status_code = response.code();
        if (status_code == TOKEN_OVERDUE) {
            Toast.makeText(ctx, context.getString(R.string.relogin), Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, LoginActivity.class));
            return;
        }
    }


}
