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
import cn.sportstory.android.entity.CurrentAccount;
import cn.sportstory.android.ui.base.BaseActivity;
import cn.sportstory.android.ui.home.HomeActivity;

/**
 * Created by Tamas on 2017/7/27.
 */

public class PasswordLoginActivity extends BaseActivity implements PasswordLoginContract.View {
    PasswordLoginContract.Presenter mPresenter;

    private CurrentAccount mCurrentAccount;

    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.et_password)
    EditText mEtPassword;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCurrentAccount=CurrentAccount.getInstance(getApplicationContext());
        if(mCurrentAccount.isValid()){
            toHomeActivity();
            finish();
        }
        setContentView(R.layout.activity_login_password);
        ButterKnife.bind(this);
        new PasswordLoginPresenter(this,getApplicationContext());

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.btn_login_with_password)
    void onBtnLoginWithPasswordClicked(View view){
        showProgress("正在登陆",false);
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

        hideProgress();
        toHomeActivity();

    }

    @Override
    public void onLoginFail(String msg) {
        //hideProgress();//TODO promote user infomation
        showDialog("登陆失败",msg);

    }

    private void toHomeActivity(){
        Intent toHomeActivity=new Intent(PasswordLoginActivity.this,HomeActivity.class);
        startActivity(toHomeActivity);

    }
}
