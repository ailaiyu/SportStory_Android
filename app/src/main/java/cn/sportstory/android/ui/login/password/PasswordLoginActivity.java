package cn.sportstory.android.ui.login.password;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sportstory.android.R;
import cn.sportstory.android.ui.base.BaseActivity;
import cn.sportstory.android.ui.home.HomeActivity;

/**
 * Created by Tamas on 2017/7/27.
 */

public class PasswordLoginActivity extends BaseActivity implements PasswordLoginContract.View {
    PasswordLoginContract.Presenter mPresenter;


    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.et_password)
    EditText mEtPassword;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);
        ButterKnife.bind(this);

        new PasswordLoginPresenter(this,getApplicationContext());

    }

    @OnClick(R.id.btn_login_with_password)
    void onBtnLoginWithPasswordClicked(View view){
        showMsg("正在登陆",false);
        String account=mEtAccount.getEditableText().toString();
        String password=mEtPassword.getEditableText().toString();
        mPresenter.login(account,password);
    }

    @Override
    public void setPresenter(PasswordLoginContract.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void onLoginSuccess() {
        hideMsg();
        Intent toHomeActivity=new Intent(this, HomeActivity.class);
        startActivity(toHomeActivity);

    }

    @Override
    public void onLoginFail(String msg) {

    }
}
