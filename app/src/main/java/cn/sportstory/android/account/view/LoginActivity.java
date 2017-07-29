package cn.sportstory.android.account.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.account.contract.LoginTaskContract;
import cn.sportstory.android.account.contract.SendVCodeTaskContract;
import cn.sportstory.android.account.presenter.LoginPresenter;
import cn.sportstory.android.account.presenter.SendVCodePresenter;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.bean.UserLoginBean;
import cn.sportstory.android.common.tools.TextCheckUtil;
import cn.sportstory.android.tools.CountTimerButton;

import static cn.sportstory.android.common.bean.UserLoginBean.LOGIN_TYPE_PHONE_VCODE;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button mBtnSendVCode;
    private TextInputEditText mEvPhone, mEvCode;
    private SendVCodePresenter sendVCodePresenter;
    private SendVCodeView sendVCodeView;
    private LoginView loginView;
    private CountTimerButton countTimerButton;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login_login).setOnClickListener(this);
        findViewById(R.id.tv_login_with_password).setOnClickListener(this);
        mBtnSendVCode = (Button)findViewById(R.id.btn_send_vcode);
        findViewById(R.id.btn_send_vcode).setOnClickListener(this);
        findViewById(R.id.btn_login_login).setOnClickListener(this);
        findViewById(R.id.tv_login_register).setOnClickListener(this);
        mEvPhone = (TextInputEditText)findViewById(R.id.ev_login_phone);
        mEvCode = (TextInputEditText)findViewById(R.id.ev_login_vcode);
        mBtnSendVCode.setOnClickListener(this);
        sendVCodeView = new SendVCodeView();
        loginView = new LoginView();
        sendVCodePresenter = new SendVCodePresenter(sendVCodeView);
        loginPresenter = new LoginPresenter(loginView);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.btn_login_login:
                login();
                break;
            case R.id.tv_login_with_password:
                intent.setClass(this, LoginWithPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_send_vcode:
               sendVCode();
                break;
            case R.id.tv_login_register:
                intent.setClass(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void login(){
        String phone = mEvPhone.getText() == null ? null : mEvPhone.getText().toString();
        String code = mEvCode.getText() == null ? null : mEvCode.getText().toString();
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(code))
        {
            Toast.makeText(LoginActivity.this, getString(R.string.account_or_code_wrong), Toast.LENGTH_SHORT).show();
            return;
        }else {
            UserLoginBean bean = new UserLoginBean();
            bean.setCode(code);
            bean.setPhone(phone);
            bean.setLogin_type(UserLoginBean.LOGIN_TYPE_PHONE);
            bean.setLoginType(LOGIN_TYPE_PHONE_VCODE);
            loginPresenter.setupTask(bean);
            loginPresenter.doTask();
        }
    }

    /**
     * 发送验证码
     * 设置发送按钮为倒计时状态
     */
    private void sendVCode(){
        if (mEvPhone.getText() == null
                || TextUtils.isEmpty(mEvPhone.getText().toString())
                || !TextCheckUtil.IsPhone(mEvPhone.getText().toString()) ){
            Toast.makeText(this, getString(R.string.enter_right_phone), Toast.LENGTH_SHORT).show();
            return;
        }

        SendVCodeBean bean = new SendVCodeBean();
        String phone = (mEvPhone.getText()).toString();
        if (TextCheckUtil.IsPhone(phone)) {
            bean.setPhone(phone);
            bean.setType(SendVCodeBean.SEND_TYPE_PHONE);
            sendVCodePresenter.setupTask(bean);
            sendVCodePresenter.doTask();
            countTimerButton = new CountTimerButton(60 * 1000, 1000, mBtnSendVCode);
            countTimerButton.start();
        }else {
            sendVCodeView.showError(getString(R.string.enter_right_phone));
        }
    }

    /**
     * 重置发送验证码按钮为初始状态
     */
    private void resetSendStatus(){
        if (countTimerButton != null) {
            countTimerButton.onFinish();
            countTimerButton = null;
        }
    }

    private class SendVCodeView extends SendVCodeTaskContract.View {

        @Override
        public Context getViewContext() {
            return getBaseContext();
        }

        @Override
        public void showSendVCodeFailed() {
            super.showSendVCodeFailed();
            resetSendStatus();
        }

        @Override
        public void showSendSuccess() {
            super.showSendSuccess();

        }
    }

    private class LoginView extends LoginTaskContract.View{
        @Override
        public Context getViewContext() {
            return getBaseContext();
        }

        @Override
        protected void showVCodeError() {
            Toast.makeText(getBaseContext(), getString(R.string.account_or_code_wrong), Toast.LENGTH_SHORT).show();
        }

        @Override
        protected boolean isActive() {
            return false;
        }

        @Override
        public void loginSuccess() {
            //startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        @Override
        public void register() {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            finish();
        }
    }



}
