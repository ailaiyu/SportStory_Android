package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/6/25.
 */

public class ErrorBody {
    private int code;
    private String err;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
