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
import cn.sportstory.android.entity.Sport;
import cn.sportstory.android.ui.base.CustomLinearLayoutManager;

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

        List<Sport> sportList=getListFromJSON(jsonStr,Sport[].class);
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
        Intent toMainActivity=new Intent(SetSportsScoreActivity.this, MainActivity.class);
        startActivity(toMainActivity);
        finish();
    }

    private   <T> List<T> getListFromJSON(String json, Class<T[]> type) {
        T[] list = new Gson().fromJson(json, type);
        return Arrays.asList(list);
    }


}
