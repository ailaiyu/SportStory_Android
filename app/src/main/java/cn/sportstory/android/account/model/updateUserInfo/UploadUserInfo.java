package cn.sportstory.android.account.model.updateUserInfo;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.sportstory.android.account.contract.UpdateUserInfoContract;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserSportBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aaron on 2017/5/21.
 */

public class UploadUserInfo extends UpdateUserInfoModel {

    public UploadUserInfo(UpdateUserInfoContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void updateUserInfo(UserBean bean, Callback<UserBean> callback) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("nickname", bean.getNickname());
        map.put("email", bean.getEmail());
        map.put("avatar", bean.getAvatar());
        map.put("background", bean.getBackground());
        map.put("gender", bean.getGender());
        map.put("birthday", bean.getBirthday());
        map.put("stature", bean.getStature());
        map.put("weight", bean.getWeight());
        map.put("province", bean.getProvince());
        map.put("city", bean.getCity());
        map.put("weight", bean.getWeight());
        map.put("district", bean.getDistrict());
        map.put("address", bean.getAddress());
        map.put("assignment", bean.getAssignment());
        Gson gson = new Gson();
        map.put("sport", gson.toJson(bean.getSport()));
        Call<UserBean> repos = service.uploadUserInfo(map);
        repos.enqueue(callback);

    }
}
