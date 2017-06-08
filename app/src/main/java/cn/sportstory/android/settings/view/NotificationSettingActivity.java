package cn.sportstory.android.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

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
    }

    private void initView(){
        // TODO: 2017/6/9 读取sharedpreferences 初始化界面
    }
}
