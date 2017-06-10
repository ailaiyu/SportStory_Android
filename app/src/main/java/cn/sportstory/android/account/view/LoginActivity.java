package cn.sportstory.android.account.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.MainActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.account.contract.SendVCodeTaskContract;
import cn.sportstory.android.account.presenter.SendVCodePresenter;
import cn.sportstory.android.common.bean.SendVCodeBean;
import cn.sportstory.android.common.tools.TextCheckUtil;
import cn.sportstory.android.tools.CountTimerButton;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button mBtnSendVCode;
    private TextInputEditText mEvPhone, mEvCode;
    private SendVCodePresenter sendVCodePresenter;
    private SendVCodeView sendVCodeView;
    private CountTimerButton countTimerButton;
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
        sendVCodePresenter = new SendVCodePresenter();
        sendVCodeView = new SendVCodeView();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.btn_login_login:
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                finish();
                // TODO: 2017/5/13 验证登录信息 
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
            sendVCodePresenter.setupTask(bean, sendVCodeView);
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
        protected Context getViewContext() {
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

}
