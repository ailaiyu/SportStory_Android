package cn.sportstory.android.profile.view;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.squareup.haha.trove.THash;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.account.view.ChooseCityActivity;
import cn.sportstory.android.common.tools.NetUtil;
import cn.sportstory.android.common.tools.ViewUtils;

/**
 * Created by aaron on 2017/5/14.
 */

public class EditProfileActivity extends BaseActivity implements View.OnClickListener{
    private static final int REQUEST_CODE_CITY = 100;
    private LinearLayout mLlNickname;
    private LinearLayout mLlGender;
    private LinearLayout mLlHeight;
    private LinearLayout mLlWeight;
    private LinearLayout mLlBirthday;
    private LinearLayout mLlAddress;

    private TextView mTvNickname;
    private TextView mTvGender;
    private TextView mTvHeight;
    private TextView mTvWeight;
    private TextView mTvBirthday;
    private TextView mTvCity;

    private boolean saved = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mLlAddress = (LinearLayout)findViewById(R.id.ll_edit_profile_address);
        mLlBirthday = (LinearLayout)findViewById(R.id.ll_edit_profile_birthday);
        mLlGender = (LinearLayout)findViewById(R.id.ll_edit_profile_gender);
        mLlHeight = (LinearLayout)findViewById(R.id.ll_edit_profile_height);
        mLlWeight = (LinearLayout)findViewById(R.id.ll_edit_profile_weight);
        mLlNickname = (LinearLayout)findViewById(R.id.ll_edit_profile_nickname);

        mTvBirthday = (TextView)findViewById(R.id.tv_edit_profile_birthday);
        mTvCity = (TextView)findViewById(R.id.tv_city);
        mTvGender = (TextView)findViewById(R.id.tv_gender);
        mTvHeight = (TextView)findViewById(R.id.tv_height);
        mTvNickname = (TextView)findViewById(R.id.tv_nickname);
        mTvWeight = (TextView)findViewById(R.id.tv_weight);

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
                startActivityForResult(new Intent(this, ChooseCityActivity.class), REQUEST_CODE_CITY);
                break;
            case R.id.ll_edit_profile_gender:
                final String[] gender = {getString(R.string.gender_male),getString(R.string.gender_female)};
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle(getString(R.string.gender))
                        .setItems(gender, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mTvGender.setText(gender[which]);
                            }
                        });
                builder.create().show();
                break;
            case R.id.ll_edit_profile_height:
                showHeightDialog();
                break;
            case R.id.ll_edit_profile_weight:
                showWeightDialog();
                break;
            case R.id.ll_edit_profile_birthday:
               showBirthdayDialog();
                break;
            case R.id.ll_edit_profile_nickname:
               showNicknameDialog();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CITY){

        }
    }

    private void showHeightDialog(){
        int height = 170;
        if (mTvHeight.getText() != null) {
            String str = mTvHeight.getText().toString().trim().replace("cm", "");
            if (!TextUtils.isEmpty(str))
                height = Integer.parseInt(str);
        }
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        final NumberPicker numberPicker = new NumberPicker(this);
//        int padding = (int)ViewUtils.dipToPx(this, 10f);
//        numberPicker.setPadding(padding, padding, padding, padding);
        numberPicker.setMinValue(150);
        numberPicker.setMaxValue(220);
        numberPicker.setValue(height);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvHeight.setText(numberPicker.getValue() + "cm");
                alertDialog.dismiss();
            }
        });
        alertDialog.setTitle(getString(R.string.height));
        alertDialog.setView(numberPicker);
        alertDialog.show();
    }

    private void showBirthdayDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                String m = monthOfYear + 1 + "";
                if (monthOfYear < 9)
                    m = "0" + m;
                String d = "" + dayOfMonth;
                if (d.length() == 1)
                    d = "0" + d;
                mTvBirthday.setText(year + "年" + m + "月" + d + "日");
            }
        }, 2010,1, 1);
        datePickerDialog.show();
    }

    private void showNicknameDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.pop_edit, null);
        final EditText content = (EditText)view.findViewById(R.id.content);
        content.setText(mTvNickname == null ? null : mTvNickname.getText().toString());
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this)
                .setView(view).setTitle(getString(R.string.nickname_with_4_30))
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (content.getText() != null && !TextUtils.isEmpty(content.getText().toString().trim()))
                            mTvNickname.setText(content.getText().toString().trim());
                    }
                });
        builder1.create().show();
    }

    private void showWeightDialog(){
        int height = 65;
        if (mTvHeight.getText() != null) {
            String str = mTvWeight.getText().toString().trim().replace("kg", "");
            if (!TextUtils.isEmpty(str))
                height = Integer.parseInt(str);
        }
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        final NumberPicker numberPicker = new NumberPicker(this);
//        int padding = (int)ViewUtils.dipToPx(this, 10f);
//        numberPicker.setPadding(padding, padding, padding, padding);
        numberPicker.setMinValue(40);
        numberPicker.setMaxValue(100);
        numberPicker.setValue(height);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvWeight.setText(numberPicker.getValue() + "kg");
                alertDialog.dismiss();
            }
        });
        alertDialog.setTitle(getString(R.string.weight));
        alertDialog.setView(numberPicker);
        alertDialog.show();
    }
}

