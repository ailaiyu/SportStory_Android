package cn.sportstory.android.ui.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.SimpleUserInfoWithLocation;
import cn.sportstory.android.ui.nearby.filter.NearbyFilterActivity;
import cn.sportstory.android.ui.nearby.filter.NearbySearchActivity;


public class NearbyFragment extends Fragment implements NearbyContract.View,SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.rv_nearby)
    RecyclerView mRvNearby;


    private RvNearbyAdapter mAdapter;
    private List<SimpleUserInfoWithLocation> mNearbyUserList;
    private NearbyContract.Presenter mPresenter;

    @BindView(R.id.swipe_nearby)
    SwipeRefreshLayout mSwipeRefresh;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nearby, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mNearbyUserList=new ArrayList<>();
        mAdapter=new RvNearbyAdapter(mNearbyUserList,getContext());
        GridLayoutManager manager=new GridLayoutManager(getContext(),3);
        mRvNearby.setLayoutManager(manager);
        mRvNearby.setAdapter(mAdapter);
        new NearbyPresenter(this,getContext());
        mPresenter.fetchNearbyUserList();
        mSwipeRefresh.setOnRefreshListener(this);


    }

    @Override
    public void setPresenter(NearbyContract.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void onNearbyUserListFetched(List<SimpleUserInfoWithLocation> userInfoList) {
        mSwipeRefresh.setRefreshing(false);
        mNearbyUserList.clear();
        mNearbyUserList.addAll(userInfoList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        mPresenter.fetchNearbyUserList();
    }

    @OnClick(R.id.iv_filter)
    void onIvFilterClicked(){
        Intent toFilterActivity=new Intent(getActivity(),NearbyFilterActivity.class);
        startActivity(toFilterActivity);
    }
    @OnClick(R.id.iv_search)
    void onIvSearchClicked(){
        Intent toNearbySearchActivity=new Intent(getActivity(),NearbySearchActivity.class);
        startActivity(toNearbySearchActivity);
    }
}
