package cn.sportstory.android.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/7.
 */

public class CurrentPhoneActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_current_phone);
        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7  进入验证新手机号页面
            }
        });
    }
}
