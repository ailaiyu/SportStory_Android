package cn.sportstory.android.account.model.follow;

import android.content.Context;

import cn.sportstory.android.account.contract.UserFollowContract;
import cn.sportstory.android.common.baseinterface.BaseModel;
import cn.sportstory.android.common.baseinterface.BasePresenter;

/**
 * Created by aaron on 2017/5/28.
 */

public abstract class FollowModel extends BaseModel {
    public FollowModel(BasePresenter presenter) {
        super(presenter);
    }
}
