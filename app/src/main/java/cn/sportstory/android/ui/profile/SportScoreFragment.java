package cn.sportstory.android.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sportstory.android.R;
import cn.sportstory.android.constants.TestConstants;
import cn.sportstory.android.entity.Sport;
import cn.sportstory.android.ui.base.BaseFragment;
import cn.sportstory.android.ui.login.perfectinfo.ScoreListAdapter;
import cn.sportstory.android.util.JsonUtil;
import cn.sportstory.android.util.SPUtil;

/**
 * Created by Tamas on 2017/7/17.
 */

public class SportScoreFragment extends BaseFragment {

    List<Sport> mSportList;

    @BindView(R.id.rv_score_list)
    RecyclerView mRvScoreList;

    ScoreListAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sports_score, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String jsonStr= SPUtil.getInstance(getContext()).getString(TestConstants.KEY_SPORT,"");
        mSportList= JsonUtil.getListFromJSON(jsonStr,Sport[].class);
        if(mSportList==null)mSportList=new ArrayList<>();

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRvScoreList.setLayoutManager(layoutManager);
        mAdapter=new ScoreListAdapter(mSportList);
        mRvScoreList.setAdapter(mAdapter);


    }


}
