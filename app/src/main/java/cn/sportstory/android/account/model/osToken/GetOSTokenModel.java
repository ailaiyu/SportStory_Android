package cn.sportstory.android.account.model.osToken;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.OSTokenBean;
import cn.sportstory.android.common.bean.UserAccountBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/6/22.
 */

public class GetOSTokenModel extends BaseModel {
    public GetOSTokenModel(BasePresenter presenter) {
        super(presenter);
    }

    public void getToken(OSTokenBean bean, Callback<OSTokenBean> callback) {
        Call<OSTokenBean> repos = service.getOsToken(bean.getType());
        repos.enqueue(callback);
    }
}
