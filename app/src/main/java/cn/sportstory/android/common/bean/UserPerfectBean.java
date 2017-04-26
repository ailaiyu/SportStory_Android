package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 完善用户信息 用户个人信息 运动类型
 */
public class UserPerfectBean extends CommonBean {
    private UserBean userBean;                      //用户信息
    private UserSportTypeBean userSportTypeBean;    //用户运动类型
    private int status;                             //保存结果

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserSportTypeBean getUserSportTypeBean() {
        return userSportTypeBean;
    }

    public void setUserSportTypeBean(UserSportTypeBean userSportTypeBean) {
        this.userSportTypeBean = userSportTypeBean;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
