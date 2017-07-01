package cn.sportstory.android.account.model.updateUserInfo;


import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UploadUserInfo extends UpdateUserInfoModel {
    public UploadUserInfo(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void updateUserInfo(UserBean bean, Callback<UserBean> callback) {
        Call<UserBean> repos = service.uploadUserInfo(bean);
        repos.enqueue(callback);
    }
}
