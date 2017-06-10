package cn.sportstory.android.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/9.
 */

public class NotificationSettingActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_notification);
        initView();
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initView(){
        // TODO: 2017/6/9 读取sharedpreferences 初始化界面
    }
}
