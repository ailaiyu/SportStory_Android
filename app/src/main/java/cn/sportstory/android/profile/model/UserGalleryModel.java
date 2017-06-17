package cn.sportstory.android.profile.model;

import android.content.Context;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.bean.UserGalleryBean;
import cn.sportstory.android.profile.contract.UserGalleryContract;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public abstract class UserGalleryModel extends BaseModel {

    public UserGalleryModel(BasePresenter presenter) {
        super(presenter);
    }

    abstract public void getUserGallery(UserGalleryBean bean, Callback<UserGalleryBean> callback);

}
