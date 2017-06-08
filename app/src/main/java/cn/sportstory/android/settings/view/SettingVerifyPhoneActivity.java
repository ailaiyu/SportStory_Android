package cn.sportstory.android.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/8.
 */

public class SettingVerifyPhoneActivity extends BaseActivity {
    private TextInputEditText phone;
    private TextInputEditText code;
    private Button send;
    private Button confirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_verify_phone);
        initView();
    }

    private void initView(){
        phone = (TextInputEditText)findViewById(R.id.phone);
        code = (TextInputEditText)findViewById(R.id.vcode);
        send = (Button)findViewById(R.id.send);
        confirm = (Button)findViewById(R.id.verify);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVCode();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();
            }
        });
    }

    private void sendVCode(){
        // TODO: 2017/6/8 发送验证码 
    }
    private void verify(){
        // TODO: 2017/6/8 验证手机号

    }
}
