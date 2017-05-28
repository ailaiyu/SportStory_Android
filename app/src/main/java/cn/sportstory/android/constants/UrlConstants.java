package cn.sportstory.android.constants;


/**
 * Created by  Aaron.Zhang on 17-3-30.
 * 接口url
 */

public class UrlConstants {

    public static final String DOMAIN = "http://59.111.92.6:80/v1/";                //企业ip

    public static final String SEND_VCODE = "vcode/send";                           //发送短信验证码 POST
    public static final String PHONE_INFO = "phone/info";                           //上传手机信息 POST
    public static final String USER_LOGON = "user/logon";                           //用户注册  POST
    public static final String USER_LOGIN = "user/login";                           //用户登录  POST
    public static final String USER_NICKNAME = "user/nickname";                     //用户修改昵称  POST
    public static final String USER_EMAIL = "user/email";                           //用户修改邮箱  POST
    public static final String USER_PHONE = "user/phone";                           //用户修手机  POST
    public static final String USER_AVATAR = "user/avatar";                         //用户修改头像  POST
    public static final String USER_BACKGROUND = "user/background";                 //用户修改背景  POST
    public static final String USER_GENDER = "user/gender";                         //用户修改性别  POST
    public static final String USER_BODY = "user/body";                             //用户修改身高体重信息  POST
    public static final String USER_AREA = "user/area";                             //用户修改地区  POST
    public static final String USER_SPORT = "user/sport";                           //用户修改运动类型  POST
    public static final String USER_LOCATION = "user/location";                     //上传地理位置  POST
    public static final String USER_NEARBY = "user/nearby";                         //附近的人  GET
    public static final String USER_PROFILE = "user/profile";                       //获取用户信息  GET
    public static final String USER_GALLERY = "user/gallery";                       //获取用户相册  GET
    public static final String USER_SEARCH = "user/search";                         //用户搜索  GET

    public static final String TIMELINE_GET = "timeline/get";                       //获取动态  GET
    public static final String TIMELINE_POST = "timeline/post";                     //发表动态  POST
    public static final String TIMELINE_DEL = "timeline/del";                       //删除动态  POST
    public static final String TIMELINE_LIKE = "timeline/like";                     //动态点赞  POST
    public static final String TIMELINE_COMMENT = "timeline/comment";               //动态评论  POST
    public static final String TIMELINE_FOLLOW = "timeline/follow";                 //关注/取关  GET
    public static final String TIMELINE_FOLLOWER = "timeline/follower";             //粉丝列表  GET


}
