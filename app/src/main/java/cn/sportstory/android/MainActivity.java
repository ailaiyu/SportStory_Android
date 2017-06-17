package cn.sportstory.android;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.sportstory.android.activities.view.ActivityFragment;
import cn.sportstory.android.chat.view.ConversationFragment;
import cn.sportstory.android.profile.view.MeFragment;
import cn.sportstory.android.nearby.view.NearbyFragment;
import cn.sportstory.android.profile.view.ProfileAlbumFragment;
import cn.sportstory.android.profile.view.ProfileSportsFragment;
import cn.sportstory.android.timeline.view.TimelineContentList;
import cn.sportstory.android.timeline.view.PostTimelineActivity;
import cn.sportstory.android.timeline.view.TimelineFragment;

/**
 * Created by Aaron.Zhang on 17-3-25.
 */

public class MainActivity extends BaseActivity implements NearbyFragment.OnFragmentInteractionListener,
        ConversationFragment.OnFragmentInteractionListener, TimelineFragment.OnFragmentInteractionListener,
        ActivityFragment.OnFragmentInteractionListener,
        MeFragment.OnFragmentInteractionListener,
        TimelineContentList.OnFragmentInteractionListener,
        ProfileSportsFragment.OnFragmentInteractionListener,
        ProfileAlbumFragment.OnFragmentInteractionListener,
        View.OnClickListener{

    private View mMenuTab;

    private RelativeLayout mRlNearby;
    private RelativeLayout mRlTimeline;
    private RelativeLayout mRlPost;
    private RelativeLayout mRlChat;
    private RelativeLayout mRlMe;

    private ImageView mIvNearby;
    private ImageView mIvTimeline;
    private ImageView mIvChat;
    private ImageView mIvMe;

    private TextView mTvNearby;
    private TextView mTvTimeline;
    private TextView mTvChat;
    private TextView mTvMe;

    private int tabTextColorFree;
    private int tabTextColorPress;

    private NearbyFragment nearbyFragment;
    private TimelineFragment timelineFragment;
    private ConversationFragment ConversationFragment;
    private MeFragment meFragment;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        tabTextColorFree = ContextCompat.getColor(getApplicationContext(),R.color.menu_text_color_free);
        tabTextColorPress = ContextCompat.getColor(getApplicationContext(),R.color.menu_text_color_press);


        mMenuTab = (View)findViewById(R.id.menu_tab);
        // 每个tab
        mRlNearby = (RelativeLayout)mMenuTab.findViewById(R.id.rl_menu_nearby);
        mRlTimeline = (RelativeLayout)mMenuTab.findViewById(R.id.rl_menu_timeline);
        mRlPost = (RelativeLayout)mMenuTab.findViewById(R.id.rl_menu_post);
        mRlChat = (RelativeLayout)mMenuTab.findViewById(R.id.rl_menu_chat);
        mRlMe = (RelativeLayout)mMenuTab.findViewById(R.id.rl_menu_me);

        // 每个tab的图片
        mIvNearby = (ImageView) mMenuTab.findViewById(R.id.iv_menu_nearby);
        mIvTimeline = (ImageView)mMenuTab.findViewById(R.id.iv_menu_timeline);
        mIvChat = (ImageView)mMenuTab.findViewById(R.id.iv_menu_chat);
        mIvMe = (ImageView)mMenuTab.findViewById(R.id.iv_menu_me);

        // 每个tab的文字
        mTvNearby = (TextView) mMenuTab.findViewById(R.id.tv_menu_nearby);
        mTvTimeline = (TextView)mMenuTab.findViewById(R.id.tv_menu_timeline);
        mTvChat = (TextView)mMenuTab.findViewById(R.id.tv_menu_chat);
        mTvMe = (TextView)mMenuTab.findViewById(R.id.tv_menu_me);

        mRlNearby.setOnClickListener(this);
        mRlTimeline.setOnClickListener(this);
        mRlPost.setOnClickListener(this);
        mRlChat.setOnClickListener(this);
        mRlMe.setOnClickListener(this);

        changeTab(R.id.rl_menu_nearby);

    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        // 先将每个tab设置为未选择状态，然后修改被选择的tab样式，展示相应的fragment
        initAllTab();
        changeTab(v.getId());
    }


    private void initAllTab(){
        mTvNearby.setTextColor(tabTextColorFree);
        mTvTimeline.setTextColor(tabTextColorFree);
        mTvChat.setTextColor(tabTextColorFree);
        mTvMe.setTextColor(tabTextColorFree);

        mIvNearby.setImageResource(R.mipmap.nearby_free);
        mIvTimeline.setImageResource(R.mipmap.timeline_free);
        mIvChat.setImageResource(R.mipmap.chat_free);
        mIvMe.setImageResource(R.mipmap.me_free);
    }


    /**
     * @param tabId 目标tab
     *修改被选择的tab为选中状态，加载相应的fragment
     */
    private void changeTab(int tabId){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragments();
        switch (tabId){
            case R.id.rl_menu_nearby:
                mIvNearby.setImageResource(R.mipmap.nearby_press);
                mTvNearby.setTextColor(tabTextColorPress);
                if(nearbyFragment == null)
                {
                    nearbyFragment = new NearbyFragment();
                    nearbyFragment.setArguments(getIntent().getExtras());
                    fragmentTransaction.add(R.id.fl_main_container, nearbyFragment).commit();
                }else {
                    fragmentTransaction.show(nearbyFragment).commit();
                }
                break;
            case R.id.rl_menu_timeline:
                mIvTimeline.setImageResource(R.mipmap.timeline_press);
                mTvTimeline.setTextColor(tabTextColorPress);
                if(timelineFragment == null)
                {
                    timelineFragment = new TimelineFragment();
                    timelineFragment.setArguments(getIntent().getExtras());
                    fragmentTransaction.add(R.id.fl_main_container, timelineFragment).commit();
                }else {
                    fragmentTransaction.show(timelineFragment).commit();
                }

                break;
            case R.id.rl_menu_post:
                startActivity(new Intent(MainActivity.this, PostTimelineActivity.class));
                break;

            case R.id.rl_menu_chat:
                mIvChat.setImageResource(R.mipmap.chat_press);
                mTvChat.setTextColor(tabTextColorPress);
                if(ConversationFragment == null)
                {
                    ConversationFragment = new ConversationFragment();
                    ConversationFragment.setArguments(getIntent().getExtras());
                    fragmentTransaction.add(R.id.fl_main_container, ConversationFragment).commit();
                }else {
                    fragmentTransaction.show(ConversationFragment).commit();
                }
                break;
            case R.id.rl_menu_me:
                mIvMe.setImageResource(R.mipmap.me_press);
                mTvMe.setTextColor(tabTextColorPress);
                if(meFragment == null)
                {
                    meFragment = new MeFragment();
                    meFragment.setArguments(getIntent().getExtras());
                    fragmentTransaction.add(R.id.fl_main_container, meFragment).commit();
                }else {
                    fragmentTransaction.show(meFragment).commit();
                }
                break;

        }
    }

    private void hideFragments(){
        if (nearbyFragment!=null)
            fragmentTransaction.hide(nearbyFragment);
        if (timelineFragment!=null)
            fragmentTransaction.hide(timelineFragment);
        if (ConversationFragment!=null)
            fragmentTransaction.hide(ConversationFragment);
        if (meFragment!=null)
            fragmentTransaction.hide(meFragment);
    }

}