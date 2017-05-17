package cn.sportstory.android.profile.view;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

import static cn.sportstory.android.profile.view.FollowersListActivity.FRAGMENT_TAG;

/**
 * Created by aaron on 2017/5/16.
 */

public class ProfileOtherActivity extends BaseActivity implements View.OnClickListener,
        ProfileTimelineFragment.OnFragmentInteractionListener,
        ProfileSportsFragment.OnFragmentInteractionListener,
        ProfileAlbumFragment.OnFragmentInteractionListener {
    private ViewGroup mProfileHead;
    private View mProfileContent;
    private FrameLayout mFlContent;
    private TextView mTvFollowersNumber, mTvFollowingNumber;
    private LinearLayout mLlFollowersNumber, mLlFollowingNumber, mLlTimeline, mLlData, mLlAlbum;

    private ProfileAlbumFragment albumFragment;
    private ProfileSportsFragment sportsFragment;
    private ProfileTimelineFragment timelineFragment;
    private static final int FRAGMENT_TIMELINE = 0, FRAGMENT_DATA = 1, FRAGMENT_ALBUM = 2;

    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_other);
        mProfileHead = (ViewGroup)findViewById(R.id.profile_head);
        mProfileContent = (View)findViewById(R.id.profile_content);

        mTvFollowersNumber = (TextView)mProfileHead.findViewById(R.id.tv_profile_followers_number);
        mTvFollowingNumber = (TextView)mProfileHead.findViewById(R.id.tv_profile_following_number);
        mLlFollowingNumber = (LinearLayout) mProfileHead.findViewById(R.id.ll_profile_following_number);
        mLlFollowersNumber = (LinearLayout)mProfileHead.findViewById(R.id.ll_profile_followers_number);

        mFlContent = (FrameLayout)mProfileContent.findViewById(R.id.fl_profile_content);
        mLlTimeline = (LinearLayout)mProfileContent.findViewById(R.id.ll_profile_content_timeline);
        mLlData = (LinearLayout)mProfileContent.findViewById(R.id.ll_profile_content_data);
        mLlAlbum = (LinearLayout)mProfileContent.findViewById(R.id.ll_profile_content_album);

        mLlFollowersNumber.setOnClickListener(this);
        mLlFollowingNumber.setOnClickListener(this);

        mLlData.setOnClickListener(this);
        mLlAlbum.setOnClickListener(this);
        mLlTimeline.setOnClickListener(this);
        changeFragment(FRAGMENT_TIMELINE);
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
                startActivity(intent);

                break;
            case R.id.ll_profile_following_number:
                bundle.putInt(FRAGMENT_TAG, FollowersListActivity.FOLLOWING_LIST);
                intent.putExtras(bundle);
                intent.setClass(this, FollowersListActivity.class);
                startActivity(intent);

                break;
            case R.id.ll_profile_content_album:
                changeFragment(FRAGMENT_ALBUM);
                break;
            case R.id.ll_profile_content_data:
                changeFragment(FRAGMENT_DATA);
                break;
            case R.id.ll_profile_content_timeline:
                changeFragment(FRAGMENT_TIMELINE);
                break;

        }
    }

    private void changeFragment(int tag){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment();
        switch (tag){
            case FRAGMENT_ALBUM:
                if (albumFragment == null)
                {
                    albumFragment = new ProfileAlbumFragment();
                    fragmentTransaction.add(R.id.fl_profile_content, albumFragment).commit();
                }else
                {
                    fragmentTransaction.show(albumFragment).commit();
                }
                break;
            case FRAGMENT_DATA:
                if (sportsFragment == null)
                {
                    sportsFragment = new ProfileSportsFragment();
                    fragmentTransaction.add(R.id.fl_profile_content, sportsFragment).commit();
                }else
                {
                    fragmentTransaction.show(sportsFragment).commit();
                }
                break;
            case FRAGMENT_TIMELINE:
                if (timelineFragment == null)
                {
                    timelineFragment = new ProfileTimelineFragment();
                    timelineFragment.setArguments(getIntent().getExtras());
                    fragmentTransaction.add(R.id.fl_profile_content, timelineFragment).commit();
                }else
                {
                    fragmentTransaction.show(timelineFragment).commit();
                }
                break;
        }
    }

    private void hideFragment(){
        if (timelineFragment != null)
            fragmentTransaction.hide(timelineFragment);
        if (albumFragment != null)
            fragmentTransaction.hide(albumFragment);
        if (sportsFragment != null)
            fragmentTransaction.hide(sportsFragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
