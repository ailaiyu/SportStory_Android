package cn.sportstory.android.account.contract;

import android.content.Context;
import android.widget.Toast;

import cn.sportstory.android.R;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;

/**
 * Created by aaron on 2017/5/19.
 */

public interface SendVCodeTaskContract {
    abstract class View extends BaseView<Presenter>{
        public void showSendSuccess(){
            Context context = getViewContext();
            if (context != null)
            {
                Toast.makeText(context, context.getString(R.string.send_vcode_success), Toast.LENGTH_SHORT).show();
            }
        }
        // 发送验证码失败
        public void showSendVCodeFailed(){
            Context context = getViewContext();
            if (context != null)
            {
                Toast.makeText(context, context.getString(R.string.send_vcode_failed), Toast.LENGTH_SHORT).show();
            }
        }
    }

    interface Presenter extends BasePresenter {

    }
}
