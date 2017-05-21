package cn.sportstory.android.account.model.uploadUserLocation;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UploadUserLocationContract;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.bean.UserLocationBean;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aaron on 2017/5/21.
 */

public class UploadUserLocation extends UploadUserLocationModel {

    public UploadUserLocation(UploadUserLocationContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void uploadLocation(UserLocationBean bean, Callback<UserLocationBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("lat", bean.getLat());
        map.put("lon", bean.getLon());
        Call<UserLocationBean> repos = service.uploadUserLocation(map);
        repos.enqueue(callback);
    }
}
