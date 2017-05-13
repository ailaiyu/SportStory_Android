package cn.sportstory.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.sportstory.android.tools.CountTimerButton;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button mBtnSendVCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_login_login).setOnClickListener(this);
        findViewById(R.id.tv_login_with_password).setOnClickListener(this);
        mBtnSendVCode = (Button)findViewById(R.id.btn_send_vcode);
        mBtnSendVCode.setOnClickListener(this);
        findViewById(R.id.btn_send_vcode).setOnClickListener(this);
        findViewById(R.id.btn_login_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login_login:
                // TODO: 2017/5/13 验证登录信息 
                break;
            case R.id.tv_login_with_password:
                // TODO: 2017/5/13
                startActivity(new Intent().setClass(LoginActivity.this, LoginWithPasswordActivity.class));
                break;
            case R.id.btn_send_vcode:
                // TODO: 2017/5/13 发送验证码
                CountTimerButton countTimerButton = new CountTimerButton(60 * 1000, 1000, mBtnSendVCode);
                countTimerButton.start();
                break;
        }
    }
}
