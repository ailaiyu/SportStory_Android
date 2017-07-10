package cn.sportstory.android.entity;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

/**
 * Created by Tamas on 2017/7/9.
 */

public class Story {
    public static final int TYPE_PURE_TEXT=1;//纯文本
    public static final int TYPE_SINGLE_PICTUR=2;//单图+文字（可选）
    public static final int TYPE_MULTI_PICTUR=3;//多图+文字（可选）

    private String nickName;//昵称
    private String avatar;//头像图片url
    private String text;//文本
    private String images;//图片
    private int commentNum;//评论数
    private int likeNum;//赞数
    private long timeStamp;//创建时间戳
    @Expose//Gson忽略
    private int type;//类型
    @Expose
    private ArrayList<String> imageUrlList;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(ArrayList<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }
}
