package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/4/9.
 */
public class CommonBean {
    private int status_code;
    private String err;
    private String success;
    private String token;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
