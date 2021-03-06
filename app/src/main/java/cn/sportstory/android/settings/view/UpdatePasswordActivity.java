package cn.sportstory.android.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/8.
 */

public class UpdatePasswordActivity extends BaseActivity {

    private TextInputEditText psd;
    private TextInputEditText cfmPsd;
    private Button confirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_update_password);
        initView();

        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initView(){
        psd = (TextInputEditText)findViewById(R.id.psd);
        cfmPsd = (TextInputEditText)findViewById(R.id.psd_confirm);
        confirm = (Button)findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
    }

    private void confirm(){
        // TODO: 2017/6/8 更新密码请求
        Toast.makeText(this, "更改成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
