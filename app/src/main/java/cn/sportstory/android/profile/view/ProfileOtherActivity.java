package cn.sportstory.android.profile.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

import static cn.sportstory.android.profile.view.FollowersListActivity.FRAGMENT_TAG;

/**
 * Created by aaron on 2017/5/16.
 */

public class ProfileOtherActivity extends BaseActivity implements View.OnClickListener {
    private ViewGroup mProfileHead;
    private ViewGroup mProfileContent;
    private TextView mTvFollowersNumber, mTvFollowingNumber;
    private LinearLayout mLlFollowersNumber, mLlFollowingNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_other);
        mProfileHead = (ViewGroup)findViewById(R.id.profile_head);
        mProfileContent = (ViewGroup)findViewById(R.id.profile_content);

        mTvFollowersNumber = (TextView)mProfileHead.findViewById(R.id.tv_profile_followers_number);
        mTvFollowingNumber = (TextView)mProfileHead.findViewById(R.id.tv_profile_following_number);
        mLlFollowingNumber = (LinearLayout) mProfileHead.findViewById(R.id.ll_profile_following_number);
        mLlFollowersNumber = (LinearLayout)mProfileHead.findViewById(R.id.ll_profile_followers_number);

        mLlFollowersNumber.setOnClickListener(this);
        mLlFollowingNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.ll_profile_followers_number:
                bundle.putInt(FRAGMENT_TAG, FollowersListActivity.FOLLOWERS_LIST);
                intent.putExtras(bundle);
                intent.setClass(this, FollowersListActivity.class);
                break;
            case R.id.ll_profile_following_number:
                bundle.putInt(FRAGMENT_TAG, FollowersListActivity.FOLLOWING_LIST);
                intent.putExtras(bundle);
                intent.setClass(this, FollowersListActivity.class);
                break;
        }
        startActivity(intent);
    }

}
