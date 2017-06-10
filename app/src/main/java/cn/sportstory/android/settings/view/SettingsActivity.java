package cn.sportstory.android.settings.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.profile.view.EditProfileActivity;

/**
 * Created by aaron on 2017/6/6.
 */

public class SettingsActivity extends BaseActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
    }

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.edit_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 edit profile
                startActivity(new Intent(SettingsActivity.this, EditProfileActivity.class));
            }
        });

        findViewById(R.id.security).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 security
                startActivity(new Intent(SettingsActivity.this, AccountSecurityActivity.class));
            }
        });

        findViewById(R.id.msg_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 消息推送
                startActivity(new Intent(SettingsActivity.this, NotificationSettingActivity.class));

            }
        });
        findViewById(R.id.verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 实名认证
//                startActivity(new Intent(SettingsActivity.this, .class));
            }
        });
        findViewById(R.id.about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 about
                startActivity(new Intent(SettingsActivity.this, AboutActivity.class));

            }
        });

        findViewById(R.id.invite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 invite
            }
        });

        findViewById(R.id.contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 同步通讯录
            }
        });
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 检查更新
            }
        });
        findViewById(R.id.clear_storagy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7 清空缓存
            }
        });
    }
}
