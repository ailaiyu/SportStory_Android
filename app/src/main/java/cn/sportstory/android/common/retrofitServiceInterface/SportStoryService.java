package cn.sportstory.android.common.retrofitServiceInterface;

import java.util.Map;

import cn.sportstory.android.common.bean.OSTokenBean;
import cn.sportstory.android.common.bean.PhoneInfoBean;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.common.bean.TimelineCommentBean;
import cn.sportstory.android.common.bean.TimelineGetBean;
import cn.sportstory.android.common.bean.TimelineLikeBean;
import cn.sportstory.android.common.bean.UserAccountBean;
import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.bean.UserFollowerBean;
import cn.sportstory.android.common.bean.UserFollowingBean;
import cn.sportstory.android.common.bean.UserGalleryBean;
import cn.sportstory.android.common.bean.UserLocationBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.common.bean.UserNearbyBean;
import cn.sportstory.android.common.bean.UserSearchBean;
import cn.sportstory.android.constants.UrlConstants;
import cn.sportstory.android.common.bean.SendVCodeBean;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by aaron on 2017/4/7.
 * 运动故事服务端的访问接口
 * 使用post方法访问
 */
public interface SportStoryService {

    /**
     * 发送短信验证码
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.SEND_VCODE)
    Call<SendVCodeBean> sendVcode(
            @Body SendVCodeBean bean
    );

    /**
     * 上传手机信息
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.PHONE_INFO)
    Call<PhoneInfoBean> uploadPhoneInfo(
            @Body PhoneInfoBean bean
    );

    /**
     * 用户注册
     *
    
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_LOGON)
    Call<UserBean> uploadUserInfo(
            @FieldMap Map<String, String> fields
    );

    /**
     * 用户登录
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_LOGIN)
    Call<UserLoginBean> userLogin(
            @Body UserLoginBean bean
    );

    /**
     * 用户更新昵称
     *
    
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_NICKNAME)
    Call<UserBean> updateNickname(
            @Body Map<String, String> fields
    );

    /**
     * 用户更新邮箱
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_EMAIL)
    Call<UserBean> updateEmail(
            @Body UserBean bean
    );

    /**
     * 用户更新手机
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_PHONE)
    Call<UserBean> updatePhone(
            @Body UserBean bean
    );


    /**
     * 更新用户头像
     *
    
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_AVATAR)
    Call<UserBean> updateUserAvatar(
            @FieldMap Map<String, String> fields
    );

    /**
     * 更新用户背景图片
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_BACKGROUND)
    Call<UserBean> updateUserBackground(
            @Body UserBean bean
    );

    /**
     * 更新用户性别
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_GENDER)
    Call<UserBean> updateUserGender(
            @Body UserBean bean

    );

    /**
     * 更新用户体格信息
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_BODY)
    Call<UserBean> updateUserBody(
            @Body UserBean bean
    );

    /**
     * 更新用户地区信息
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_AREA)
    Call<UserBean> updateUserArea(
            @Body UserBean bean
    );

    /**
     * 更新用户运动类型
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_SPORT)
    Call<UserBean> updateUserSport(
            @Body UserBean bean
    );

    /**
     * 更换手机号
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_SPORT)
    Call<UserAccountBean> changePhone(
            @Body UserAccountBean bean
    );


    /**
     * 更换邮箱
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_SPORT)
    Call<UserAccountBean> changeEmail(
            @Body UserAccountBean bean
    );

    /**
     * 上传用户地理位置
     *
    
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.USER_LOCATION)
    Call<UserLocationBean> uploadUserLocation(
            @Body UserLocationBean bean
    );

    /**
     * 获取用户相册
     *
     * @return
     */
    @GET(UrlConstants.USER_GALLERY)
    Call<UserGalleryBean> getUserGallery(
        @Body UserGalleryBean bean
    );


    /**
     * 获取附近的人
     *
     * @param options
     * @return
     */
    @GET(UrlConstants.USER_NEARBY)
    Call<UserNearbyBean> getUserNearby(
            @QueryMap Map<String, String> options
    );

    /**
     * 搜索用户
     *
     * @return
     */
    @GET(UrlConstants.USER_SEARCH)
    Call<UserSearchBean> searchUser(
            @Body UserSearchBean bean
            );

    /**
     * 获取动态
     *
     * @return
     */
    @GET(UrlConstants.TIMELINE_GET)
    Call<TimelineGetBean> getTimeline(
            @Body TimelineGetBean bean
            );


    /**
     * 发送状态
     *
    
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.TIMELINE_POST)
    Call<TimelineBean> postTimeline(
            @FieldMap Map<String, String> fields
    );

    /**
     * 删除动态
     *
    
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.TIMELINE_DEL)
    Call<TimelineBean> delTimeline(
            @Body TimelineBean bean
    );

    /**
     * 点赞动态或取消赞
     *
     * @return
     */
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST(UrlConstants.TIMELINE_LIKE)
    Call<TimelineLikeBean> timelineLike(
        @Body TimelineLikeBean bean
    );

    /**
     * 点赞动态或取消赞
     *
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.TIMELINE_COMMENT)
    Call<TimelineCommentBean> timelineComment(
            @Body TimelineCommentBean bean
    );


    /**
     * 获取粉丝列表
     *
     * @return
     */
    @GET(UrlConstants.USER_FOLLOWER)
    Call<UserFollowerBean> getFollowers(
            @Body UserFollowerBean bean
    );

    /**
     * 移除粉丝
     *
     * @return
     */
    @POST(UrlConstants.USER_FOLLOWER)
    Call<UserFollowerBean> userFollow(
            @Body UserFollowerBean bean
    );

    /**
     * 获取关注列表
     *
     * @return
     */
    @GET(UrlConstants.USER_FOLLOWING)
    Call<UserFollowingBean> getFollowing(
            @Body UserFollowingBean been
    );

    /**
     * 关注或取关
     *
     * @param bean
     * @return
     */
    @POST(UrlConstants.USER_FOLLOWING)
    Call<UserFollowingBean> userFollowing(
            @Body UserFollowingBean bean
    );

    /**
     * 获取token
     *
     * @return
     */
    @GET(UrlConstants.STORAGE_TOKEN)
    Call<OSTokenBean> getOsToken(
            @Query("type") String type
    );

}
