package cn.sportstory.android.account.presenter;

import cn.sportstory.android.account.contract.UpdateUserInfoContract;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserAvatar;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserBackground;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserEmail;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserGender;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserInfoModel;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserNickname;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserPhone;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserShape;
import cn.sportstory.android.account.model.updateUserInfo.UpdateUserSport;
import cn.sportstory.android.account.model.updateUserInfo.UploadUserInfo;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.CommonBean;
import cn.sportstory.android.common.bean.UserBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaron on 2017/5/21.
 */

public class UpdateUserInfoPresenter extends UpdateUserInfoContract.Presenter {
    private UserBean bean;
    private UpdateUserInfoContract.View view;
    private UpdateUserInfoModel model;

    private static final int UPDATE_TYPE_UPLOAD = 100;
    private static final int UPDATE_TYPE_AREA = 1;
    private static final int UPDATE_TYPE_AVATAR = 2;
    private static final int UPDATE_TYPE_BACKGROUND = 3;
    private static final int UPDATE_TYPE_EMAIL = 4;
    private static final int UPDATE_TYPE_GENDER = 5;
    private static final int UPDATE_TYPE_NICKNAME = 6;
    private static final int UPDATE_TYPE_PHONE = 7;
    private static final int UPDATE_TYPE_SHAPE = 8;
    private static final int UPDATE_TYPE_SPORT = 9;

    @Override
    public void doTask() {
        model.updateUserInfo(bean, new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {

            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void setupTask(CommonBean bean, BaseView view) {
        this.bean = (UserBean) bean;
        this.view = (UpdateUserInfoContract.View) view;
        switch (((UserBean) bean).getUpdateType()) {
            case UPDATE_TYPE_UPLOAD:
                model = new UploadUserInfo(this);
                break;
            case UPDATE_TYPE_AREA:
                model = new UpdateUserAvatar(this);
                break;
            case UPDATE_TYPE_AVATAR:
                model = new UpdateUserAvatar(this);
                break;
            case UPDATE_TYPE_BACKGROUND:
                model = new UpdateUserBackground(this);
                break;
            case UPDATE_TYPE_EMAIL:
                model = new UpdateUserEmail(this);
                break;
            case UPDATE_TYPE_GENDER:
                model = new UpdateUserGender(this);
                break;
            case UPDATE_TYPE_NICKNAME:
                model = new UpdateUserNickname(this);
                break;
            case UPDATE_TYPE_PHONE:
                model = new UpdateUserPhone(this);
                break;
            case UPDATE_TYPE_SHAPE:
                model = new UpdateUserShape(this);
                break;
            case UPDATE_TYPE_SPORT:
                model = new UpdateUserSport(this);
                break;

        }
    }
}
