package cn.sportstory.android.settings.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/8.
 */

public class CurrentEmailActivity extends BaseActivity {

    private TextView email;
    private String currentEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_current_email);
        initView();
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initView(){
        email = (TextView)findViewById(R.id.email);

        // TODO: 2017/6/8 获取当前邮箱 展示

        findViewById(R.id.binding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(SettingBindingEmailActivity.EXTRA_STRING_CURRENT_EMAIL, currentEmail);
                intent.setClass(CurrentEmailActivity.this, SettingBindingEmailActivity.class);
                startActivityForResult(intent, SettingBindingEmailActivity.REQUEST_CODE_BINDING_EMAIL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SettingBindingEmailActivity.REQUEST_CODE_BINDING_EMAIL)
        {
            if (resultCode == SettingBindingEmailActivity.RESULT_CODE_BINDING_EMAIL_SUCCESS) {
                currentEmail = data.getStringExtra("email");
                email.setText(currentEmail);
            }
        }
    }
}
