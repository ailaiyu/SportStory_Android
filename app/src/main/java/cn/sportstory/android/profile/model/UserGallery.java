package cn.sportstory.android.profile.model;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.bean.UserGalleryBean;
import cn.sportstory.android.profile.contract.UserGalleryContract;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserGallery extends UserGalleryModel {

    public UserGallery(UserGalleryContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getUserGallery(UserGalleryBean bean, Callback<UserGalleryBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("f_id", bean.getF_id());
        map.put("start", bean.getStart());
        map.put("num", bean.getNum());
        Call<UserGalleryBean> repos = service.getUserGallery(map);
        repos.enqueue(callback);
    }
}
