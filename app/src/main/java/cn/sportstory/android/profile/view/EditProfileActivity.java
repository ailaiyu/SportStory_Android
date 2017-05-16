package cn.sportstory.android.profile.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/14.
 */

public class EditProfileActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout mLlNickname;
    private LinearLayout mLlGender;
    private LinearLayout mLlHeight;
    private LinearLayout mLlWeight;
    private LinearLayout mLlBirthday;
    private LinearLayout mLlAddress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        mLlAddress = (LinearLayout)findViewById(R.id.ll_edit_profile_address);
        mLlBirthday = (LinearLayout)findViewById(R.id.ll_edit_profile_birthday);
        mLlGender = (LinearLayout)findViewById(R.id.ll_edit_profile_gender);
        mLlHeight = (LinearLayout)findViewById(R.id.ll_edit_profile_height);
        mLlWeight = (LinearLayout)findViewById(R.id.ll_edit_profile_weight);
        mLlNickname = (LinearLayout)findViewById(R.id.ll_edit_profile_nickname);

        mLlNickname.setOnClickListener(this);
        mLlWeight.setOnClickListener(this);
        mLlGender.setOnClickListener(this);
        mLlAddress.setOnClickListener(this);
        mLlBirthday.setOnClickListener(this);
        mLlHeight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ll_edit_profile_address:
                break;
            case R.id.ll_edit_profile_gender:
                break;
            case R.id.ll_edit_profile_height:
                break;
            case R.id.ll_edit_profile_weight:
                break;
            case R.id.ll_edit_profile_birthday:
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        String m = monthOfYear + 1 + "";
                        if (monthOfYear < 9)
                            m = "0" + m;
                        String d = "" + dayOfMonth;
                        if (d.length() == 1)
                            d = "0" + d;
                        ((TextView)findViewById(R.id.tv_edit_profile_birthday)).setText(year + "年" + m + "月" + d + "日");
                    }
                }, 2010,1, 1);
                datePickerDialog.show();

                break;
            case R.id.ll_edit_profile_nickname:
                break;

        }
    }
}
