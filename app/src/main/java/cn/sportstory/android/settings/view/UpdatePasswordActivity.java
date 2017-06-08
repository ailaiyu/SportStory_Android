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

public class UpdatePasswordActivity extends BaseActivity {

    private TextInputEditText psd;
    private TextInputEditText cfmPsd;
    private Button confirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_update_password);
        initView();
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
    }
}
