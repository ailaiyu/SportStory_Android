package cn.sportstory.android.entity;

/**
 * Created by Tamas on 2017/7/12.
 */
public class GenericResultWithData<T> extends GenericResult{
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
