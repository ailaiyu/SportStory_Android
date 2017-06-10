package cn.sportstory.android.account.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RegionIterator;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.common.tools.CameraHelper;
import cn.sportstory.android.common.tools.ImageTools;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aaron on 2017/5/13.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private ImageView mImgFemale;
    private ImageView mImgMale;
    private Button mBtnConfirm;
    private CircleImageView mImgAvatar;
    private Toolbar toolbar;

    private boolean isFemale = false;
    private boolean isMale = false;

    private int gender = -1;
    private static final int GENDER_MALE = 0;
    private static final int GENDER_FEMALE = 1;
    CameraHelper cameraHelper = new CameraHelper();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mImgAvatar = (CircleImageView)findViewById(R.id.img_register_avatar);
        mImgMale = (ImageView)findViewById(R.id.img_register_male);
        mImgFemale = (ImageView)findViewById(R.id.img_register_female);
        mBtnConfirm = (Button)findViewById(R.id.btn_register_finish);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mImgFemale.setOnClickListener(this);
        mImgMale.setOnClickListener(this);
        mImgAvatar.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.btn_register_finish:
                intent.setClass(this, PerfectInfoAddressActivity.class);
                startActivity(intent);
                break;
            case R.id.img_register_avatar:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("上传头像")
                        .setItems(new String[]{"拍照", "相册"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (which == 0) {
                            // TODO: 2017/5/13  打开相机
                            cameraHelper.takePhoto(RegisterActivity.this);
                        }else {
                            // TODO: 2017/5/13 打开相册

                        }
                    }
                }).create();
                alertDialog.show();
                break;
            case R.id.img_register_female:
                if (!isFemale){
                    isFemale = true;
                    isMale = false;
                    mImgMale.setImageResource(R.mipmap.male_free);
                    mImgFemale.setImageResource(R.mipmap.female_choose);
                    gender = GENDER_FEMALE;
                }else {
                    isFemale = false;
                    mImgFemale.setImageResource(R.mipmap.female_free);
                }
                break;
            case R.id.img_register_male:
                if (!isMale){
                    isMale = true;
                    isFemale = false;
                    mImgMale.setImageResource(R.mipmap.male_choose);
                    mImgFemale.setImageResource(R.mipmap.female_free);
                    gender = GENDER_MALE;
                }else {
                    isMale = false;
                    mImgMale.setImageResource(R.mipmap.male_free);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null)
            return;
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == CameraHelper.CAMERA_REQUEST_CODE)
            {
                try{
                    Uri uri = data.getData();
                    cameraHelper.startCropImage(RegisterActivity.this, uri);
                }catch (Exception e){
                    Toast.makeText(this, getString(R.string.operation_failed), Toast.LENGTH_SHORT).show();
                }

            }else if (requestCode == CameraHelper.ALBUM_REQUEST_CODE){

            }else if (requestCode == CameraHelper.CROP_REQUEST){
                File cropFile = new File(CameraHelper.SAVED_IMAGE_DIR_PATH + System.currentTimeMillis() + ".jpg");
                Uri uri = Uri.fromFile(cropFile);
                try{
                    Bitmap pic = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    pic = ImageTools.imageZoom(pic, 500);
                    mImgAvatar.setImageBitmap(pic);
                }catch (IOException e){
                    Toast.makeText(RegisterActivity.this, getString(R.string.operation_failed), Toast.LENGTH_SHORT).show();
                }

            }else {
                return;
            }
        }
    }
}
