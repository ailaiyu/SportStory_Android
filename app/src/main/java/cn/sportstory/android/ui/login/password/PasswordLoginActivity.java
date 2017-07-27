package cn.sportstory.android.ui.login.password;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.widget.EditText;

import butterknife.ButterKnife;
import cn.sportstory.android.R;
import cn.sportstory.android.ui.base.BaseActivity;

/**
 * Created by Tamas on 2017/7/27.
 */

public class PasswordLoginActivity extends BaseActivity {


    EditText mEtAccount;
    EditText mEtPassword;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);
        ButterKnife.bind(this);

    }

}
