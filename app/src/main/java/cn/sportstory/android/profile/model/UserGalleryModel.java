package cn.sportstory.android.profile.model;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.UserGalleryBean;
import cn.sportstory.android.profile.contract.UserGalleryContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UserGalleryModel extends BaseModel {

    private UserGalleryContract.Presenter presenter;

    public UserGalleryModel(UserGalleryContract.Presenter presenter) {
        this.presenter = presenter;
    }

    abstract public void getUserGallery(UserGalleryBean bean, Callback<UserGalleryBean> callback);

}
