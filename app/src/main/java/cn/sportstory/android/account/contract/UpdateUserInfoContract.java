package cn.sportstory.android.account.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserBean;

/**
 * Created by aaron on 2017/5/21.
 */

public interface UpdateUserInfoContract {
    abstract class Presenter extends BasePresenter{
        public Presenter(BaseView baseView) {
            super(baseView);
        }

    }

    abstract class View extends BaseView{
        public void uploadUserInfoSuccess(UserBean bean){}      //注册时 上传信息成功
        public void uploadUserInfoFailed(UserBean bean){}       //注册时 上传信息失败
        public void updateNicknameSuccess(UserBean bean){}      //修改昵称成功
        public void updateNicknameFailed(UserBean bean){}       //修改昵称失败
        public void updateAvatarSuccess(UserBean bean){}        //修改头像成功
        public void updateAvatarFailed(UserBean bean){}         //修改头像失败
        public void updateBackgroundSuccess(UserBean bean){}    //修改背景成功
        public void updateBackgroundFailed(UserBean bean){}     //修改背景失败
        public void updateGenderSuccess(UserBean bean){}        //修改性别成功
        public void updateGenderFailed(UserBean bean){}         //修改性别失败
        public void updateShapeSuccess(UserBean bean){}         //修改体型成功
        public void updateShapeFailed(UserBean bean){}          //修改体型失败
        public void updateAreaSuccess(UserBean bean){}          //修改地区成功
        public void updateAreaFailed(UserBean bean){}           //修改地区失败
        public void updateSportSuccess(UserBean bean){}         //修改运动成功
        public void updateSportFailed(UserBean bean){}          //修改运动失败

    }
}
