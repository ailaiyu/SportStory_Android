package cn.sportstory.android.tools;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/13.
 */

public class CountTimerButton extends CountDownTimer{
    private Button button;
    public CountTimerButton(long millisInFuture, long countDownInterval, Button button) {
        super(millisInFuture, countDownInterval);
        this.button = button;
        this.button.setEnabled(false);
        this.button.setTextColor(Color.parseColor("#FFFFFF"));
        this.button.setBackgroundResource(R.drawable.round_button_send_vcde_disabled);
    }



    @Override
    public void onTick(long millisUntilFinished) {
        button.setText(millisUntilFinished / 1000 + "");
    }

    @Override
    public void onFinish() {
        button.setText("点击发送");
        button.setEnabled(true);
        button.setBackgroundResource(R.drawable.round_button_send_vcode);
    }
}
