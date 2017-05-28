package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/5/28.
 */

public class UserFollowingBean extends CommonBean {
    private String f_id;
    private String start;
    private String num;
    private String f_type;

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getF_type() {
        return f_type;
    }

    public void setF_type(String f_type) {
        this.f_type = f_type;
    }
}
