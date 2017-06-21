package cn.sportstory.android.common.bean;

import java.util.Date;

/**
 * Created by aaron on 2017/5/21.
 */

public class UserGalleryBean extends CommonBean {
    private String f_id;
    private String start;
    private String num;
    private UserPhoto[] gallery;

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

    public UserPhoto[] getGallery() {
        return gallery;
    }

    public void setGallery(UserPhoto[] gallery) {
        this.gallery = gallery;
    }
}
