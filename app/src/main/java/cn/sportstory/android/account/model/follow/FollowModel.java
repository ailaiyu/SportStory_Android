package cn.sportstory.android.account.model.follow;

import cn.sportstory.android.account.contract.UserFollowContract;
import cn.sportstory.android.common.baseinterface.BaseModel;

/**
 * Created by aaron on 2017/5/28.
 */

public abstract class FollowModel extends BaseModel {
    private UserFollowContract.Presenter presenter;

    public FollowModel(UserFollowContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
