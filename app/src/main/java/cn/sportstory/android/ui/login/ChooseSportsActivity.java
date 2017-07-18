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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Sport;
import cn.sportstory.android.ui.base.BaseRvAdapter;
import cn.sportstory.android.ui.base.CustomGridLayoutManager;
import cn.sportstory.android.util.NotifyUtil;

/**
 * Created by Tamas on 2017/7/9
 */

public class ChooseSportsActivity extends AppCompatActivity {
    private static final String TAG=ChooseSportsActivity.class.getName();

    public static final String KEY_JSON_STR="SPORT_LIST_JSON";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rv_choose_sports)
    RecyclerView mRvSportList;

    List<Sport> mSportList;

    SportListAdapter mAdapter;

    private int mSelectedSportNum;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sports);
        ButterKnife.bind(this);


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        makeSport();

        CustomGridLayoutManager layoutManager=new CustomGridLayoutManager(getApplicationContext(),3);
        layoutManager.setScrollEnabled(false);
        mRvSportList.setLayoutManager(layoutManager);
        mAdapter=new SportListAdapter(mSportList);
        mRvSportList.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseRvAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Sport item=mSportList.get(position);
                if(view.isSelected()){
                    view.setSelected(false);
                    item.setSelected(false);
                    mSelectedSportNum--;
                }else if(mSelectedSportNum==3){
                    NotifyUtil.showSnackMsg(view,"只能3项运动哦");
                    return;
                }else{
                    view.setSelected(true);
                    item.setSelected(true);
                    mSelectedSportNum++;
                }
            }
        });

    }
    @OnClick(R.id.btn_choose_sports_finish)
    void onBtnChooseSportsFinishClicked(){
        List<Sport> choosedSportList=new ArrayList<>();
        for(Sport item:mSportList){
            if(item.isSelected())choosedSportList.add(item);
        }
        Gson gson=new Gson();
        String jsonStr=gson.toJson(choosedSportList);
        Intent toSetScoreActivity=new Intent(ChooseSportsActivity.this,SetSportsScoreActivity.class);
        toSetScoreActivity.putExtra(KEY_JSON_STR,jsonStr);
        Log.i(TAG,"jsonStr:"+jsonStr);
        startActivity(toSetScoreActivity);
        //Intent
    }

    private void makeSport(){
        mSportList=new ArrayList<>();

        Sport sport1=new Sport();
        sport1.setName("乒乓球");
        sport1.setImageRes(R.drawable.selector_pinpon);

        Sport sport2=new Sport();
        sport2.setName("羽毛球");
        sport2.setImageRes(R.drawable.selector_badminton);

        Sport sport3=new Sport();
        sport3.setName("篮球");
        sport3.setImageRes(R.drawable.selector_basketball);

        Sport sport4=new Sport();
        sport4.setName("自行车");
        sport4.setImageRes(R.drawable.selector_bicycle);

        Sport sport5=new Sport();
        sport5.setName("滑雪");
        sport5.setImageRes(R.drawable.selector_skiing);

        Sport sport6=new Sport();
        sport6.setName("跑步");
        sport6.setImageRes(R.drawable.selector_run);

        Sport sport7=new Sport();
        sport7.setName("足球");
        sport7.setImageRes(R.drawable.selector_soccor);

        Sport sport8=new Sport();
        sport8.setName("游泳");
        sport8.setImageRes(R.drawable.selector_swim);

        Sport sport9=new Sport();
        sport9.setName("棒球");
        sport9.setImageRes(R.drawable.selector_baseball);

        mSportList.add(sport1);
        mSportList.add(sport2);
        mSportList.add(sport3);
        mSportList.add(sport4);
        mSportList.add(sport5);
        mSportList.add(sport6);
        mSportList.add(sport7);
        mSportList.add(sport8);
        mSportList.add(sport9);
    }
}
