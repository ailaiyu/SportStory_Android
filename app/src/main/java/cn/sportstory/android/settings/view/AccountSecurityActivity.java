package cn.sportstory.android.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/7.
 */

public class AccountSecurityActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_account_security);
        initView();
    }

    private void initView(){
        findViewById(R.id.change_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 修改密码 
            }
        });
        
        findViewById(R.id.change_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 修改邮箱 
            }
        });
        findViewById(R.id.change_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 修改手机号
            }
        });
    }
}
