package cn.sportstory.android.entity;

/**
 * Created by Tamas on 2017/7/12.
 */
public class GenericResult {
    private int status;
    private String message;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
