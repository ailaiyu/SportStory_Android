package cn.sportstory.android.common.bean;

/**
 * Created by aaron on 2017/5/28.
 */

public class TimelineCommentBean extends CommonBean {
    private String t_id;
    private String content;
    private String to;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
