package cn.sportstory.android.profile.model;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserGalleryBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserGallery extends UserGalleryModel {

    public UserGallery(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public void getUserGallery(UserGalleryBean bean, Callback<UserGalleryBean> callback) {
        Call<UserGalleryBean> repos = service.getUserGallery(bean);
        repos.enqueue(callback);
    }
}
