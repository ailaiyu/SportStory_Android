package cn.sportstory.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginWithPasswordActivity extends BaseActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_password);
        findViewById(R.id.btn_login_with_psd_login).setOnClickListener(this);
        findViewById(R.id.tv_login_with_vcode).setOnClickListener(this);
        findViewById(R.id.tv_login_with_password_forget_psd).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.btn_login_with_psd_login:
                // TODO: 2017/5/13 登录
                break;
            case R.id.tv_login_with_vcode:
                onBackPressed();
                break;
            case R.id.tv_login_with_password_forget_psd:
                // TODO: 2017/5/13 重置密码
                break;


        }
    }
}
