package cn.sportstory.android.settings.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.common.tools.CacheManager;
import cn.sportstory.android.profile.view.EditProfileActivity;

/**
 * Created by aaron on 2017/6/6.
 */

public class SettingsActivity extends BaseActivity {
    Toolbar toolbar;

    private TextView cacheSize;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
    }

    private void initView(){
        cacheSize =(TextView)findViewById(R.id.cache_size);
        try {
            cacheSize.setText(CacheManager.getCacheSize(this));
        }catch (Exception e){

        }
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
                View view = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.loading_content, null, false);
                TextView content = (TextView)view.findViewById(R.id.content);
                content.setText(getString(R.string.cleaning));
                final Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.setContentView(view);
                dialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CacheManager.cleanApplicationCache(SettingsActivity.this);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        cacheSize.setText(CacheManager.getCacheSize(SettingsActivity.this));
                                    }catch (Exception e){

                                    }
                                    if (dialog.isShowing())
                                        dialog.dismiss();
                                }
                            });
                        }
                }).start();


            }
        });
    }
}
