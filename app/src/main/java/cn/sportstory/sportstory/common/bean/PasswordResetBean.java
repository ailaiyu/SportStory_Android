package cn.sportstory.sportstory.common.bean;

/**
 * Created by aaron on 2017/4/9.
 * 重置密码
 */
public class PasswordResetBean extends CommonBean {
    private String item;            //新密码
    private String status;          //重置结果

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}