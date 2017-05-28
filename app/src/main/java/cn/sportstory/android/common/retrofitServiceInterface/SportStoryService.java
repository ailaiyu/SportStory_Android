package cn.sportstory.android.common.retrofitServiceInterface;

import java.util.Map;

import cn.sportstory.android.common.bean.PhoneInfoBean;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.common.bean.TimelineCommentBean;
import cn.sportstory.android.common.bean.TimelineGetBean;
import cn.sportstory.android.common.bean.TimelineLikeBean;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserGalleryBean;
import cn.sportstory.android.common.bean.UserLocationBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.common.bean.UserNearbyBean;
import cn.sportstory.android.common.bean.UserSearchBean;
import cn.sportstory.android.constants.UrlConstants;
import cn.sportstory.android.common.bean.SendVCodeBean;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by aaron on 2017/4/7.
 * 运动故事服务端的访问接口
 * 使用post方法访问
 */
public interface SportStoryService {

    /**
     * 发送短信验证码
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.SEND_VCODE)
    Call<SendVCodeBean> sendVcode(
            @FieldMap Map<String, String> fields
    );

    /**
     * 上传手机信息
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.PHONE_INFO)
    Call<PhoneInfoBean> uploadPhoneInfo(
            @FieldMap Map<String, String> fields
    );

    /**
     * 用户注册
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_LOGON)
    Call<UserBean> uploadUserInfo(
            @FieldMap Map<String, String> fields
    );

    /**
     * 用户登录
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_LOGIN)
    Call<UserLoginBean> userLogin(
            @FieldMap Map<String, String> fields
    );

      /**
     * 用户更新昵称
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_NICKNAME)
    Call<UserBean> updateNickname(
            @FieldMap Map<String, String> fields
    );

    /**
     * 用户更新邮箱
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_EMAIL)
    Call<UserBean> updateEmail(
            @FieldMap Map<String, String> fields
    );

    /**
     * 用户更新手机
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_PHONE)
    Call<UserBean> updatePhone(
            @FieldMap Map<String, String> fields
    );



    /**
     * 更新用户头像
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_AVATAR)
    Call<UserBean> updateUserAvatar(
            @FieldMap Map<String, String> fields
    );

    /**
     * 更新用户背景图片
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_BACKGROUND)
    Call<UserBean> updateUserBackground(
            @FieldMap Map<String, String> fields
    );

    /**
     * 更新用户性别
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_GENDER)
    Call<UserBean> updateUserGender(
            @FieldMap Map <String, String> fields
    );

    /**
     * 更新用户体格信息
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_BODY)
    Call<UserBean> updateUserBody(
            @FieldMap Map<String, String> fields
    );

    /**
     * 更新用户地区信息
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_AREA)
    Call<UserBean> updateUserArea(
            @FieldMap Map<String, String> fields
    );

    /**
     * 更新用户运动类型
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_SPORT)
    Call<UserBean> updateUserSport(
            @FieldMap Map<String, String> fields
    );

    /**
     * 上传用户地理位置
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_LOCATION)
    Call<UserLocationBean> uploadUserLocation(
            @FieldMap Map<String, String> fields
    );

    /**
     * 获取用户相册
     * @param options
     * @return
     */
    @GET(UrlConstants.USER_GALLERY)
    Call<UserGalleryBean> getUserGallery(
        @QueryMap Map<String, String> options
    );


    /**
     * 获取附近的人
     * @param options
     * @return
     */
    @GET(UrlConstants.USER_NEARBY)
    Call<UserNearbyBean> getUserNearby(
            @QueryMap Map<String, String> options
    );

    /**
     * 搜索用户
     * @param options
     * @return
     */
    @GET(UrlConstants.USER_SEARCH)
    Call<UserSearchBean> searchUser(
            @QueryMap Map<String, String> options
    );

    /**
     * 获取动态
     * @param options
     * @return
     */
    @GET(UrlConstants.TIMELINE_GET)
    Call<TimelineGetBean> getTimeline(
            @QueryMap Map<String, String> options
    );


    /**
     * 发送状态
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.TIMELINE_POST)
    Call<TimelineBean> postTimeline(
            @FieldMap Map<String, String> fields
    );

    /**
     * 删除动态
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.TIMELINE_DEL)
    Call<TimelineBean> delTimeline(
            @FieldMap Map<String, String> fields
    );

    /**
     * 点赞动态或取消赞
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.TIMELINE_LIKE)
    Call<TimelineLikeBean> timelineLike(
            @FieldMap Map<String, String> fields
    );

    /**
     * 点赞动态或取消赞
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.TIMELINE_COMMENT)
    Call<TimelineCommentBean> timelineComment(
            @FieldMap Map<String, String> fields
    );
}
