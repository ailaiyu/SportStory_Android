package cn.sportstory.android.api.request;

/**
 * Created by Tamas on 2017/7/18.
 */
public class LikeRequest {
    public static final int OPERATE_LIKE=1;
    public static final int OPERATE_DELIKE=2;

    private long toId;
    private int operate;
    private long createDate;

    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    public int getOperate() {
        return operate;
    }

    public void setOperate(int operate) {
        this.operate = operate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}
