package cn.sportstory.android.settings.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    private String comeFrom;
    public static final String COME_FROM_EXTRA_KEY = "comefrom";
    public static final String COME_FROM_CHANGE_PHONE = "update_phone";
    public static final String COME_FROM_VERIFY_PHONE = "verifyphone";
    private String phoneNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_verify_phone);
        comeFrom = getIntent().getStringExtra(COME_FROM_EXTRA_KEY);
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
        phoneNumber = phone.getText().toString();
    }
    private void verify() {
        if (!TextUtils.isEmpty(comeFrom))
        {
            if (comeFrom.equals(COME_FROM_VERIFY_PHONE)) {
                if (true) {
                    setResult(AccountSecurityActivity.VERIFY_PHONE_SUCCESS);
                }else {
                    Toast.makeText(this, "验证失败", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
            else if (comeFrom.equals(COME_FROM_CHANGE_PHONE)) {
                showChangePhoneSuccess();
            }
        }else {
            finish();
        }

    }

    public void showChangePhoneSuccess(){
        AlertDialog.Builder bd = new AlertDialog.Builder(this);
        bd.setTitle("绑定成功")
                .setMessage("您的帐号已绑定至新手机号" + phoneNumber)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }
}
