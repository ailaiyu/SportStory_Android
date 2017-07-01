package cn.sportstory.android.account.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;


import com.qiniu.android.http.ResponseInfo;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.account.contract.GetOSTokenContract;
import cn.sportstory.android.account.presenter.GetOsTokenPresenter;
import cn.sportstory.android.common.bean.OSTokenBean;
import cn.sportstory.android.common.tools.AccountHelper;
import cn.sportstory.android.common.tools.CameraHelper;
import cn.sportstory.android.common.tools.ImageTools;
import cn.sportstory.android.common.tools.PermissionUtils;
import cn.sportstory.android.common.tools.QiNiuUploadCallback;
import cn.sportstory.android.common.tools.QiNiuUploader;
import cn.sportstory.android.common.view.ProcessView;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.RequestBody;

/**
 * Created by aaron on 2017/5/13.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private ImageView mImgFemale;
    private ImageView mImgMale;
    private Button mBtnConfirm;
    private CircleImageView mImgAvatar;
    private Toolbar toolbar;
    private GetTokenView getTokenView;
    private GetOsTokenPresenter getOsTokenPresenter;

    private boolean isFemale = false;
    private boolean isMale = false;

    private int gender = -1;
    private static final int GENDER_MALE = 0;
    private static final int GENDER_FEMALE = 1;
    private String filePath;
    CameraHelper cameraHelper = new CameraHelper();
    private int openWhat = -1;

    private ProcessView processView;
    private boolean uploaded = false;

    private FrameLayout processFrameLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mImgAvatar = (CircleImageView)findViewById(R.id.img_register_avatar);
        mImgMale = (ImageView)findViewById(R.id.img_register_male);
        mImgFemale = (ImageView)findViewById(R.id.img_register_female);
        mBtnConfirm = (Button)findViewById(R.id.btn_register_finish);
        processFrameLayout = (FrameLayout)findViewById(R.id.process);
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

        getTokenView = new GetTokenView();
        getOsTokenPresenter = new GetOsTokenPresenter(getTokenView);

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
                        if (isPermissionGranted(PermissionUtils.REQUEST_CAMERA)) {
                            if (isPermissionGranted(PermissionUtils.REQUEST_WRITE_EXTERNAL_STORAGE)) {
                                openWhat = which;
                                openCamera();
                            }else {
                                requestPermission(PermissionUtils.REQUEST_WRITE_EXTERNAL_STORAGE, PermissionUtils.REQUEST_CODE_WRITE_EXTERNAL_STORAGE);
                            }
                        }
                        else
                            requestPermission(PermissionUtils.REQUEST_CAMERA, PermissionUtils.REQUEST_CODE_CAMERA);
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

    private void openCamera(){
        if (openWhat == 0) {
            // TODO: 2017/5/13  打开相机
            cameraHelper.takePhoto(RegisterActivity.this);
        }else {
            // TODO: 2017/5/13 打开相册
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
                    cameraHelper.startCropImage(RegisterActivity.this, cameraHelper.getUri());
                }catch (Exception e){
                    Toast.makeText(this, getString(R.string.operation_failed), Toast.LENGTH_SHORT).show();
                }

            }else if (requestCode == CameraHelper.ALBUM_REQUEST_CODE){

            }else if (requestCode == CameraHelper.CROP_REQUEST){
//                File cropFile = new File(CameraHelper.SAVED_IMAGE_DIR_PATH + System.currentTimeMillis() + ".jpg");
                File cropFile = new File(Environment.getExternalStorageDirectory() + "/crop_image.jpg");

                filePath = cropFile.getAbsolutePath();
                OSTokenBean bean = new OSTokenBean();
                bean.setType(OSTokenBean.FILE_TYPE_AVATAR);
                getOsTokenPresenter.setupTask(bean);
                getOsTokenPresenter.doTask();
                showProcess();
                Uri uri = FileProvider.getUriForFile(this,getPackageName() + ".fileprovider", cropFile);
                try{
                    Bitmap pic = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    pic = ImageTools.imageZoom(pic, 500);
                    mImgAvatar.setImageBitmap(pic);
                }catch (IOException e){
                    Toast.makeText(RegisterActivity.this, getString(R.string.operation_failed),
                            Toast.LENGTH_SHORT).show();
                }

            }else {
                return;
            }
        }
    }

    private class GetTokenView extends GetOSTokenContract.View{

        @Override
        public Context getViewContext() {
            return getBaseContext();
        }
        @Override
        public void getTokenSuccess(OSTokenBean bean) {
            QiNiuUploader uploader = QiNiuUploader.getInstance();
            uploader.init(bean.getToken());
            uploader.upload(filePath, AccountHelper.getUserId(RegisterActivity.this) + ".jpg", new QiNiuUploadCallback(){
                @Override
                public void success(String key, ResponseInfo info, JSONObject response) {
                    dismissProcess();
                    Toast.makeText(getViewContext(), "上传成功", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void failed(String key, ResponseInfo info, JSONObject response) {
                    dismissProcess();
                    Toast.makeText(getViewContext(), "上传失败，请重试", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void getTokenFailed(OSTokenBean bean) {
            Toast.makeText(RegisterActivity.this, "上传失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionUtils.REQUEST_CODE_CAMERA) {
            if (isPermissionGranted(PermissionUtils.REQUEST_CAMERA) && isPermissionGranted(PermissionUtils.REQUEST_WRITE_EXTERNAL_STORAGE))
                openCamera();
            else {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle(getString(R.string.tip)).setMessage("打开相机权限")
                        .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                builder.show();
            }
        } else if (requestCode == PermissionUtils.REQUEST_CODE_WRITE_EXTERNAL_STORAGE){
            if (isPermissionGranted(PermissionUtils.REQUEST_WRITE_EXTERNAL_STORAGE) && isPermissionGranted(PermissionUtils.REQUEST_CAMERA))
            {
                openCamera();
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle(getString(R.string.tip)).setMessage("打开存储空间权限")
                        .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                builder.show();
            }
        }
    }

    private void showProcess(){
        findViewById(R.id.content).setEnabled(false);
        processFrameLayout.setVisibility(View.VISIBLE);
        processView = new ProcessView(this, getString(R.string.uploading));
        processFrameLayout.removeAllViews();
        processFrameLayout.addView(processView);
        uploaded = false;
    }

    private void dismissProcess(){
        if (!uploaded) {
            uploaded = true;
            findViewById(R.id.content).setEnabled(true);
            processView.removeAllViews();
            processView = null;
            processFrameLayout.removeAllViews();
            processFrameLayout.setVisibility(View.GONE);
        }
    }
}
