package cn.sportstory.sportstory.common.retrofitServiceInterface;

import java.util.Map;

import cn.sportstory.sportstory.common.bean.SendVCodeBean;
import cn.sportstory.sportstory.common.bean.UserLogonBean;
import cn.sportstory.sportstory.constants.UrlConstants;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aaron on 2017/4/7.
 * 运动故事服务端的访问接口
 * 使用post方法访问
 */
public interface SportStoryService {

    public static final String SEND_VCODE = "vcode/send";                           //发送短信验证码
    public static final String USER_LOGON = "user/logon";                           //用户注册
    public static final String USER_PERFECT = "user/perfect";                       //上传头像
    public static final String USER_LOGIN = "user/login";                           //用户登录
    public static final String USER_RESET_PASSWORD = "user/reset/password";         //重置密码
    public static final String USER_NEIGBOR_LIST = "user/neigbor/list";             //附近的人
    public static final String USER_SEARCH = "user/search";                         //重置密码
    public static final String USER_HOME_LOAD = "user/home/load";                   //用户主页
    public static final String FEED_LIST = "feed/list";                             //动态列表
    public static final String FEED_COMMENT = "feed/comment";                       //点赞/踩/评论
    public static final String FELLOW_LIST = "follow/list";                         //关注/粉丝
    public static final String VIDEO_LIST = "video/list";                           //视频列表
    public static final String FEED_LISTOFONE = "feed/listofone";                   //指定用户动态
    public static final String ALBUM_LIST = "album/list";                           //用户相册
    public static final String ALBUM_EDIT = "album/edit";                           //编辑相册（隐私设置， 仅自己可见/粉丝可见/关注可见/公开）
    public static final String ALBUM_DELETE = "album/delete";                       //删除相册
    public static final String ALBUM_UPLOAD = "album/upload";                       //上传照片
    public static final String ALBUM_IMAGE_COMMENT = "album/image/comment";         //评论照片

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
     * 用户注册
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(UrlConstants.USER_LOGON)
    Call<UserLogonBean> userLogon(
            @FieldMap Map<String, String> fields
    );

}
