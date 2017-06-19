package cn.sportstory.android.account.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.MainActivity;
import cn.sportstory.android.R;

public class LoginWithPasswordActivity extends BaseActivity implements View.OnClickListener{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_password);
        findViewById(R.id.btn_login_with_psd_login).setOnClickListener(this);
        findViewById(R.id.tv_login_with_vcode).setOnClickListener(this);
        findViewById(R.id.tv_login_with_password_forget_psd).setOnClickListener(this);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.btn_login_with_psd_login:
                // TODO: 2017/5/13 登录
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_login_with_vcode:
                onBackPressed();
                break;
            case R.id.tv_login_with_password_forget_psd:
                // TODO: 2017/5/13 重置密码
                intent.setClass(this, VerifyPhoneActivity.class);
                startActivity(intent);
                break;


        }
    }
}
