package cn.sportstory.android.account.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.ui.login.perfectinfo.ChooseSportsActivity;

/**
 * Created by aaron on 2017/5/13.
 */

public class PerfectInfoAddressActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnNext;
    private TextView mTvSkip;
    private TextView mTvAddress;
    private RelativeLayout mRlAddress;
    private static final int GET_LOCATION = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_info_address);
        mBtnNext = (Button)findViewById(R.id.btn_perfect_info_address_next);
        mTvAddress = (TextView) findViewById(R.id.tv_perfect_info_address);
        mTvSkip = (TextView) findViewById(R.id.tv_perfect_info_address_skip);
        mRlAddress = (RelativeLayout) findViewById(R.id.rl_perfect_info_address);
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mBtnNext.setOnClickListener(this);
        mTvSkip.setOnClickListener(this);
        mRlAddress.setOnClickListener(this);
        // TODO: 2017/5/13 请求位置授权 
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_perfect_info_address_next:
                intent.setClass(this, ChooseSportsActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_perfect_info_address_skip:
//                intent.setClass(this, MainActivity.class);
//                startActivity(intent);
                break;
            case R.id.rl_perfect_info_address:
                intent.setClass(this, ChooseCityActivity.class);
                startActivityForResult(intent, GET_LOCATION);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_LOCATION){
            if (resultCode == RESULT_OK) {
                String city = data.getStringExtra("city");
                if (!TextUtils.isEmpty(city))
                    mTvAddress.setText(city);
                // TODO: 2017/6/19 更新用户地址
            }
        }
    }
}
