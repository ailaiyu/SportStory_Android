package cn.sportstory.android.ui.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.ui.addmoment.AddMomentActivity;
import cn.sportstory.android.ui.base.BaseFragment;
import cn.sportstory.android.ui.base.BaseRvAdapter;
import cn.sportstory.android.ui.timeline.detail.StoryDetailActivity;

/**
 * Created by Tamas on 2017/7/9.
 */

public class TimeLineFragment extends BaseFragment implements TimeLineContract.View,SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG=TimeLineFragment.class.getName();

    public static final String KEY_STORY="story";

    private TimeLineContract.Presenter mPresenter;

    @BindView(R.id.rv_timeline_list)
    RecyclerView mRvTimeLineList;

    private List<Story> mStoryList=new ArrayList<>();;

    @BindView(R.id.swipe_timeline)
    SwipeRefreshLayout mSwipeRefresh;

    private StoryListAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_time_line, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        new TimeLinePresenter(this,getContext());

        mSwipeRefresh.setOnRefreshListener(this);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRvTimeLineList.setLayoutManager(manager);
        mAdapter=new StoryListAdapter(mStoryList,getContext());

        mRvTimeLineList.setAdapter(mAdapter);


        mPresenter.fetchTimeLine();

        mAdapter.setOnItemClickListener(new BaseRvAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Story story=mStoryList.get(position);
                Intent toStoryDetailActivity=new Intent(getActivity(),StoryDetailActivity.class);
                toStoryDetailActivity.putExtra(KEY_STORY,story);
                startActivity(toStoryDetailActivity);
            }
        });

    }

    @OnClick(R.id.fab_add_moment)
    void onFabAddMomentClicked(){
        Intent toAddMomentActivity=new Intent(getActivity(), AddMomentActivity.class);
        startActivity(toAddMomentActivity);
    }

    @Override
    public void setPresenter(TimeLineContract.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void onTimeLineFetched(List<Story> storyList) {
        Log.i(TAG,"onTimeLineFetched size:"+storyList.size());
        mSwipeRefresh.setRefreshing(false);
        mStoryList.clear();
        mStoryList.addAll(storyList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTimeLineMoreOnePageFetched(List<Story> storyList) {
        Log.i(TAG,"onTimeLineMoreOnePageFetched");
        mStoryList.addAll(storyList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        mPresenter.fetchTimeLine();
    }
}
