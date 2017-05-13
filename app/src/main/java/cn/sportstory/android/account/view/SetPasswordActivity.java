package cn.sportstory.android.account.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/13.
 */

public class SetPasswordActivity extends BaseActivity implements View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        findViewById(R.id.btn_set_psd_confirm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_set_psd_confirm:
                finish();
                break;
        }
    }
}
