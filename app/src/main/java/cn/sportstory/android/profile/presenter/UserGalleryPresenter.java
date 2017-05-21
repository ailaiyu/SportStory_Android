package cn.sportstory.android.profile.presenter;

import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserGalleryBean;
import cn.sportstory.android.profile.contract.UserGalleryContract;
import cn.sportstory.android.profile.model.UserGallery;
import cn.sportstory.android.profile.model.UserGalleryModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserGalleryPresenter extends UserGalleryContract.Presenter {

    private UserGalleryModel model;
    private UserGalleryContract.View view;
    private UserGalleryBean bean;
    @Override
    public void doTask() {

        model.getUserGallery(bean, new Callback<UserGalleryBean>() {
            @Override
            public void onResponse(Call<UserGalleryBean> call, Response<UserGalleryBean> response) {

            }

            @Override
            public void onFailure(Call<UserGalleryBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean, BaseView view) {
        this.bean = (UserGalleryBean)bean;
        this.view = (UserGalleryContract.View)view;
        model = new UserGallery(this);
    }
}
