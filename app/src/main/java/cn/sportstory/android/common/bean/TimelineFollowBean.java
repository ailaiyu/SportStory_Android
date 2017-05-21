package cn.sportstory.android.common.bean;


/**
 * Created by aaron on 2017/5/21.
 */

public class TimelineFollowBean extends CommonBean {
    private String type;
    private String uid;
    private TimelineBean[] timeline;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public TimelineBean[] getTimeline() {
        return timeline;
    }

    public void setTimeline(TimelineBean[] timeline) {
        this.timeline = timeline;
    }
}
