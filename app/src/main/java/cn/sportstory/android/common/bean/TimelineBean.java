package cn.sportstory.android.common.bean;

import cn.sportstory.android.common.baseinterface.BaseModel;

/**
 * Created by aaron on 2017/5/21.
 */

public class TimelineBean extends CommonBean {
    private String t_id;
    private String uid;
    private String url;
    private int picCount;
    private String nickname;
    private String content;
    private String avatar;
    private String type;
    private String create_time;
    private CommentBean[] comment;
    private LikeBean[] like;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public CommentBean[] getComment() {
        return comment;
    }

    public void setComment(CommentBean[] comment) {
        this.comment = comment;
    }

    public LikeBean[] getLike() {
        return like;
    }

    public void setLike(LikeBean[] like) {
        this.like = like;
    }

    public int getPicCount() {
        return picCount;
    }

    public void setPicCount(int picCount) {
        this.picCount = picCount;
    }
}
