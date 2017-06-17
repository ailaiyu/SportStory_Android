package cn.sportstory.android.account.model.sendVCode;

import android.content.Context;

import cn.sportstory.android.account.presenter.SendVCodePresenter;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.constants.UrlConstants;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aaron on 2017/5/19.
 */

public abstract class SendVCodeModel extends BaseModel {

    public SendVCodeModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void sendVCode(SendVCodeBean bean, Callback<SendVCodeBean> callback);
}
