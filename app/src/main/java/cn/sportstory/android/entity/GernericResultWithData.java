package cn.sportstory.android.entity;

import java.util.List;

/**
 * Created by Tamas on 2017/7/9.
 */

public class GernericResultWithData<T> extends GenericResult {
    List<T> dataList ;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
