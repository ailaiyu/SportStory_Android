package cn.sportstory.android.settings.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.EventLog;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.account.model.updateAccountInfo.ChangePassword;

/**
 * Created by aaron on 2017/6/7.
 */

public class AccountSecurityActivity extends BaseActivity {

    public final static int UPDATE_PASSWORD_VERIFY_PHONE = 100;
    public final static int VERIFY_PHONE_SUCCESS = 101;
    public final static int UPDATE_PASSWORD = 200;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_account_security);
        initView();
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initView(){
        findViewById(R.id.change_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 修改密码
                startActivityForResult(new Intent(AccountSecurityActivity.this, SettingVerifyPhoneActivity.class)
                        .putExtra(SettingVerifyPhoneActivity.COME_FROM_EXTRA_KEY,
                                SettingVerifyPhoneActivity.COME_FROM_VERIFY_PHONE),
                        UPDATE_PASSWORD_VERIFY_PHONE);
            }
        });
        
        findViewById(R.id.change_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 修改邮箱
                startActivity(new Intent().setClass(AccountSecurityActivity.this, CurrentEmailActivity.class));
            }
        });
        findViewById(R.id.change_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 修改手机号
                startActivity(new Intent().setClass(AccountSecurityActivity.this, CurrentPhoneActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPDATE_PASSWORD_VERIFY_PHONE){
            if (resultCode == VERIFY_PHONE_SUCCESS)
                startActivity(new Intent().setClass(AccountSecurityActivity.this, UpdatePasswordActivity.class));


        }
    }
}
