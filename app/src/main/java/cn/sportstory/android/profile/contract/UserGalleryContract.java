package cn.sportstory.android.profile.contract;

import cn.sportstory.android.common.baseinterface.BasePresenter;
import cn.sportstory.android.common.baseinterface.BaseView;
import cn.sportstory.android.common.bean.UserGalleryBean;

/**
 * Created by aaron on 2017/5/21.
 */

public interface UserGalleryContract {
    abstract class View extends BaseView<Presenter>{
        abstract public void getGalleriesSuccess(UserGalleryBean bean);
        abstract public void getGalleriesFailed(UserGalleryBean bean);
    }

    abstract class Presenter extends BasePresenter{
        public Presenter(BaseView baseView) {
            super(baseView);
        }
    }
}
