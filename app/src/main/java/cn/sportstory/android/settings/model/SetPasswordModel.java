package cn.sportstory.android.settings.model;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserPasswordBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/7/1.
 */

public class SetPasswordModel extends BaseModel {
    public SetPasswordModel(BasePresenter presenter) {
        super(presenter);
    }

    public void setPassword(UserPasswordBean bean, Callback<UserPasswordBean> callback){
        Call<UserPasswordBean> repos = service.setPassword(bean);
        repos.enqueue(callback);
    }

}
