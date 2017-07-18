package cn.sportstory.android.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sportstory.android.R;
import cn.sportstory.android.chat.view.ChatFragment;
import cn.sportstory.android.chat.view.ConversationFragment;
import cn.sportstory.android.profile.view.MeFragment;
import cn.sportstory.android.ui.addmoment.AddMomentActivity;
import cn.sportstory.android.ui.base.BaseActivity;
import cn.sportstory.android.ui.base.CustomPagerAdapter;
import cn.sportstory.android.ui.base.CustomViewPager;
import cn.sportstory.android.ui.nearby.NearbyFragment;
import cn.sportstory.android.ui.timeline.TimeLineFragment;

/**
 * Created by Tamas on 2017/7/16.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View{

    private int mCurrentFragmentPosition=0;

    @BindViews({R.id.rl_menu_nearby,R.id.rl_menu_timeline, R.id.rl_menu_chat, R.id.rl_menu_me})
    List<RelativeLayout> mNavIvList;

    @BindView(R.id.pager_home)
    CustomViewPager mViewPager;

    String[] mTitles={"附近的人","动态","消息","我的"};

    private HomeContract.Presenter mPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);



        Fragment[] fragments=new Fragment[mTitles.length];
        fragments[0]=new NearbyFragment();
        fragments[1]=new TimeLineFragment();
        fragments[2]=new ConversationFragment();
        fragments[3]=new MeFragment();

        mNavIvList.get(0).setSelected(true);

        CustomPagerAdapter adapter = new CustomPagerAdapter(getSupportFragmentManager(), mTitles, fragments);
        mViewPager.setNoScroll(true);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Empty
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Empty
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentFragmentPosition=position;
                deSelectAllNavItem();
                mNavIvList.get(position).setSelected(true);

            }
        });
    }

    @OnClick({R.id.rl_menu_nearby,R.id.rl_menu_timeline, R.id.rl_menu_chat, R.id.rl_menu_me})
    void onNavItemClicked(View v) {
        deSelectAllNavItem();
        v.setSelected(true);
        int size = mNavIvList.size();
        for (int i = 0; i < size; i++) {
            if (v == mNavIvList.get(i)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @OnClick(R.id.rl_menu_post)
    void onNavPostStoryClicked(View view){
        Intent toAddMomentActivity=new Intent(this, AddMomentActivity.class);
        startActivity(toAddMomentActivity);
    }

    private void deSelectAllNavItem() {
        for (RelativeLayout iv : mNavIvList) {
            iv.setSelected(false);
        }
    }



    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter=presenter;
    }
}
