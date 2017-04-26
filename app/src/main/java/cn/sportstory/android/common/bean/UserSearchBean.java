package cn.sportstory.android.common.bean;

import java.util.List;

/**
 * Created by aaron on 2017/4/9.
 * 用户搜索
 * 我认为还要加三个字段:搜索起始位置 搜索结束位置 搜索类型
 */
public class UserSearchBean extends CommonBean {
    private String item;                                //搜索内容：昵称，电话，运动类型
    private List<NeigborInfoBean> neigborInfoList;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public List<NeigborInfoBean> getNeigborInfoList() {
        return neigborInfoList;
    }

    public void setNeigborInfoList(List<NeigborInfoBean> neigborInfoList) {
        this.neigborInfoList = neigborInfoList;
    }
}
