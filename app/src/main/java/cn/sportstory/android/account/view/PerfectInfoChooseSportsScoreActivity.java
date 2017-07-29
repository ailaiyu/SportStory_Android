package cn.sportstory.android.account.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.ui.home.HomeActivity;

/**
 * Created by aaron on 2017/5/14.
 */

public class PerfectInfoChooseSportsScoreActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_info_choose_sport_scores);
        findViewById(R.id.btn_perfect_info_sports_score_finish).setOnClickListener(this);
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_perfect_info_sports_score_finish:
                intent.setClass(this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
