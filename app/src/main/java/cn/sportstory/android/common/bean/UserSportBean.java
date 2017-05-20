package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/5/6.
 * 上传用户运动信息
 */

public class UserSportBean extends CommonBean {
    private String name;
    private String level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
