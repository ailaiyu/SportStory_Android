package cn.sportstory.android.account.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aaron on 2017/5/13.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private ImageView mImgFemale;
    private ImageView mImgMale;
    private Button mBtnConfirm;
    private CircleImageView mImgAvatar;

    private boolean isFemale = false;
    private boolean isMale = false;

    private int gender = -1;
    private static final int GENDER_MALE = 0;
    private static final int GENDER_FEMALE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mImgAvatar = (CircleImageView)findViewById(R.id.img_register_avatar);
        mImgMale = (ImageView)findViewById(R.id.img_register_male);
        mImgFemale = (ImageView)findViewById(R.id.img_register_female);
        mBtnConfirm = (Button)findViewById(R.id.btn_register_finish);
        mImgFemale.setOnClickListener(this);
        mImgMale.setOnClickListener(this);
        mImgAvatar.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_register_finish:
                break;
            case R.id.img_register_avatar:
                break;
            case R.id.img_register_female:
                if (!isFemale){
                    isFemale = true;
                    isMale = false;
                    mImgMale.setImageResource(R.mipmap.male_free);
                    mImgFemale.setImageResource(R.mipmap.female_choose);
                    gender = GENDER_FEMALE;
                }
                break;
            case R.id.img_register_male:
                if (!isMale){
                    isMale = true;
                    isFemale = false;
                    mImgMale.setImageResource(R.mipmap.male_choose);
                    mImgFemale.setImageResource(R.mipmap.female_free);
                    gender = GENDER_MALE;
                }
                break;
        }
    }
}
