package cn.sportstory.android.common.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import cn.sportstory.android.MainActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.account.tools.UserTokenHelper;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.ErrorBody;
import retrofit2.Response;

/**
 * Created by aaron on 2017/6/17.
 */

public class ResponseParser {

    public static final int RESPONSE_CODE_OK = 200;
    private static final int TOKEN_OVERDUE = 401;
    public static final int RESPONSE_ERR = 400;
    public static void parseResponse(Response response, BaseView view){
        if (view == null)
            return;
        Context ctx = view.getViewContext().getApplicationContext();
        String token = response.headers().get("token");
        if (!TextUtils.isEmpty(token)) {
            UserTokenHelper.updateToken(token, ctx);
        }
        int status_code = response.code();
        if (status_code == TOKEN_OVERDUE) {
            AccountHelper.changeLoginStatus(ctx, false);
            Toast.makeText(ctx, ctx.getString(R.string.relogin), Toast.LENGTH_SHORT).show();
            view.getViewContext().startActivity(new Intent(view.getViewContext(), MainActivity.class));
        }else if (status_code == RESPONSE_ERR){
            try {
                String err = response.errorBody().string();
                Gson gson = new Gson();
                ErrorBody body = gson.fromJson(err, ErrorBody.class);
                view.showError(body.getErr());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
