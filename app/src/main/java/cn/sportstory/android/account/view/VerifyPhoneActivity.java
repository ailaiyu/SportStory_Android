package cn.sportstory.android.account.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.tools.CountTimerButton;

/**
 * Created by aaron on 2017/5/13.
 */

public class VerifyPhoneActivity extends BaseActivity implements View.OnClickListener{

    private Button mBtnSendVcode;
    private Button mBtnVerify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);
        mBtnSendVcode = (Button)findViewById(R.id.btn_verify_phone_send_vcode);
        mBtnVerify = (Button)findViewById(R.id.btn_verify_phone_verify);
        mBtnSendVcode.setOnClickListener(this);
        mBtnVerify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_verify_phone_send_vcode:
                CountTimerButton countTimerButton = new CountTimerButton(60 * 1000, 1000, mBtnSendVcode);
                countTimerButton.start();
                break;
            case R.id.btn_verify_phone_verify:
                intent.setClass(this, SetPasswordActivity.class);
                startActivity(intent);
                verify();
                break;
        }
    }
    
    private void verify(){
        // TODO: 2017/5/13 验证验证码
        finish();
    }
}
