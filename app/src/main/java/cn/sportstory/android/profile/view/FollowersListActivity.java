package cn.sportstory.android.profile.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/16.
 */

public class FollowersListActivity extends BaseActivity {

    public static final int FOLLOWERS_LIST = 1;
    public static final int FOLLOWING_LIST = 2;
    public static final String FRAGMENT_TAG = "FRAGMENT_TAG";

    FragmentTransaction fragmentTransaction = null;
    private int fragment_tag = -1;
    private TextView mTvFollowing;
    private TextView mTvFollowers;

    private FollowFragment followFragment;
    private FollowFragment followingFragment;

    private String userId = "1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower_list);
        fragment_tag = getIntent().getIntExtra(FRAGMENT_TAG, FOLLOWERS_LIST);
        initView();
    }

    private void initView(){
        mTvFollowers = (TextView)findViewById(R.id.tv_follower_list_followers);
        mTvFollowing = (TextView)findViewById(R.id.tv_follower_list_following);
        showFragment(fragment_tag);


    }

    private void showFragment(int tag){
        Bundle bundle = new Bundle();
        bundle.putString("userId", userId);
        bundle.putInt("tag", tag);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (tag == FOLLOWERS_LIST){
            mTvFollowers.setTextSize(16);
            mTvFollowing.setTextSize(14);
            if (followFragment == null) {
                followFragment = new FollowFragment();
                followFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.fl_followers_list, followFragment).commit();
            }else {
                fragmentTransaction.show(followFragment).commit();
            }
        }else {
            mTvFollowers.setTextSize(14);
            mTvFollowing.setTextSize(16);
            if (followingFragment == null) {
                followFragment = new FollowFragment();
                followingFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.fl_followers_list, followingFragment).commit();
            }else {
                fragmentTransaction.show(followingFragment).commit();
            }
        }
    }
}
