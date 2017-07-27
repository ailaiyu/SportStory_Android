package cn.sportstory.android.entity;

import java.util.List;

/**
 * Created by Tamas on 2017/7/12.
 */
public class GenericResultWithList<T> extends GenericResult {
    private int page;
    private int count;
    List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
        if(list!=null)count=list.size();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount(){
        return this.count;
    }
}
