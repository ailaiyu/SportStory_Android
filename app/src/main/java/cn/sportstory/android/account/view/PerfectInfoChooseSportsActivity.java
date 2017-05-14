package cn.sportstory.android.account.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/14.
 */

public class PerfectInfoChooseSportsActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_info_choose_sports);
        findViewById(R.id.btn_perfect_info_choose_sports_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_perfect_info_choose_sports_next:
                intent.setClass(this, PerfectInfoChooseSportsScoreActivity.class);
                startActivity(intent);
                break;
        }
    }
}
