package cn.sportstory.android.settings.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/8.
 */

public class SettingBindingEmailActivity extends BaseActivity {
    public static final int REQUEST_CODE_BINDING_EMAIL = 100;
    public static final int RESULT_CODE_BINDING_EMAIL_SUCCESS = 101;
    public static final String EXTRA_STRING_CURRENT_EMAIL = "currentemail";
    String currentEmail;
    String newEmail;

    private TextInputEditText email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_binding_email);
        currentEmail = getIntent().getStringExtra(EXTRA_STRING_CURRENT_EMAIL);
        email = (TextInputEditText)findViewById(R.id.email);
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind();
            }
        });
    }

    private void bind(){
        if (email.getText() != null)
            newEmail = email.getText().toString();
        if (!TextUtils.isEmpty(newEmail) && !TextUtils.isEmpty(currentEmail) && newEmail.equals(currentEmail)) {
            Toast.makeText(this, getString(R.string.already_binding_this_email), Toast.LENGTH_SHORT).show();
        }else {
            // TODO: 2017/6/10 绑定新邮箱

            if (true) {
                // TODO: 2017/6/10 绑定成功
                Toast.makeText(this, getString(R.string.binding_email_successful), Toast.LENGTH_SHORT).show();
                setResult(RESULT_CODE_BINDING_EMAIL_SUCCESS, new Intent().putExtra("email", newEmail));
                finish();
            }
        }
    }



}
