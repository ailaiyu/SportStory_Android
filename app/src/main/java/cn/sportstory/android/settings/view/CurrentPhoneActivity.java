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
 * Created by aaron on 2017/6/7.
 */

public class CurrentPhoneActivity extends BaseActivity {

    private TextView phone;
    private String currentPhone;
    private static final int REQUEST_CODE_CHANGE_PHONE = 102;
    public static final int RESPONSE_CODE_CHANGE_PHONE_SUCCESS = 103;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_current_phone);
        phone = (TextView)findViewById(R.id.phone);
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/7  进入验证新手机号页面
                Intent intent = new Intent();
                intent.setClass(CurrentPhoneActivity.this, SettingVerifyPhoneActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(SettingVerifyPhoneActivity.COME_FROM_EXTRA_KEY, SettingVerifyPhoneActivity.COME_FROM_CHANGE_PHONE);

                currentPhone = phone.getText() == null ? null : phone.getText().toString();
                bundle.putString(SettingVerifyPhoneActivity.CURRENT_PHONE_EXTRA_KEY, currentPhone);
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODE_CHANGE_PHONE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHANGE_PHONE)
        {
            if (resultCode == RESPONSE_CODE_CHANGE_PHONE_SUCCESS)
                phone.setText(data.getStringExtra("phone"));
        }
    }
}
