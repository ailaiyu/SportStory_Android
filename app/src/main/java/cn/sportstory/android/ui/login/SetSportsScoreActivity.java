package cn.sportstory.android.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sportstory.android.MainActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.constants.TestConstants;
import cn.sportstory.android.entity.Sport;
import cn.sportstory.android.ui.base.CustomLinearLayoutManager;
import cn.sportstory.android.ui.home.HomeActivity;
import cn.sportstory.android.util.JsonUtil;
import cn.sportstory.android.util.SPUtil;

/**
 * Created by Tamas on 2017/7/9.
 * TODO 2017/7/10 生命周期管理
 */

public class SetSportsScoreActivity extends AppCompatActivity {

    private static final String TAG=SetSportsScoreActivity.class.getName();

    private List<Sport> mSportList=new ArrayList<>();

    @BindView(R.id.rv_score_list)
    RecyclerView mRvScoreList;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private ScoreListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_sports_score);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        String jsonStr=intent.getStringExtra(ChooseSportsActivity.KEY_JSON_STR);

        List<Sport> sportList= JsonUtil.getListFromJSON(jsonStr,Sport[].class);
        mSportList.addAll(sportList);
        Log.i(TAG,"list size:"+sportList.size());

        CustomLinearLayoutManager layoutManager=new CustomLinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL);
        layoutManager.setScrollEnabled(false);
        mRvScoreList.setLayoutManager(layoutManager);
        mAdapter=new ScoreListAdapter(mSportList);
        mRvScoreList.setAdapter(mAdapter);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    @OnClick(R.id.btn_to_main_activity)
    void onBtnToMainActivityClicked(){

        String jsonStr=new Gson().toJson(mSportList);
        SPUtil.getInstance(getApplicationContext()).putString(TestConstants.KEY_SPORT,jsonStr);

        Intent toHomeActivity=new Intent(SetSportsScoreActivity.this, HomeActivity.class);
        startActivity(toHomeActivity);

        finish();
    }


}
