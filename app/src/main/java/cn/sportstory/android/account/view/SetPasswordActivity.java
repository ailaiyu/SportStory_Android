package cn.sportstory.android.account.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.common.bean.PasswordResetBean;
import cn.sportstory.android.common.bean.UserPasswordBean;
import cn.sportstory.android.settings.contract.SetPasswordContract;
import cn.sportstory.android.settings.presenter.SetPasswordPresenter;

/**
 * Created by aaron on 2017/5/13.
 */

public class SetPasswordActivity extends BaseActivity implements View.OnClickListener{
    private TextInputEditText password;

    private SetPasswordPresenter setPasswordPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        findViewById(R.id.btn_set_psd_confirm).setOnClickListener(this);
        password = (TextInputEditText)findViewById(R.id.ev_set_psd_psd);
        setPasswordPresenter = new SetPasswordPresenter(setPasswordView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_set_psd_confirm:
                if (password.getText() == null || !TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(getBaseContext(), "请输入密码", Toast.LENGTH_SHORT).show();
                } else {
                    String psd = password.getText().toString();
                    int length = psd.trim().length();
                    if (length < 8 || length > 20){
                        Toast.makeText(getBaseContext(),"请输入8到20位的密码", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        PasswordResetBean bean = new PasswordResetBean();
                        setPasswordPresenter.setupTask(bean);
                        setPasswordPresenter.doTask();
                    }
                }
                break;
        }
    }

    private SetPasswordContract.View setPasswordView = new SetPasswordContract.View() {
        @Override
        public void setSuccess(UserPasswordBean bean) {
            Toast.makeText(getViewContext(), "设置成功", Toast.LENGTH_SHORT).show();
            finish();
        }

        @Override
        public void setFailed() {
            showError("操作失败，请重试");
        }

        @Override
        public Context getViewContext() {
            return getBaseContext();
        }
    };
}
