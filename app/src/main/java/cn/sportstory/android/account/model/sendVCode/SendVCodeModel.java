package cn.sportstory.android.account.model.sendVCode;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.SendVCodeBean;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/19.
 */

public abstract class SendVCodeModel extends BaseModel {

    public SendVCodeModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void sendVCode(SendVCodeBean bean, Callback<SendVCodeBean> callback);
}
