package cn.sportstory.android.common.tools;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import java.io.File;
import java.net.URI;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/18.
 */

public class CameraHelper {
    public final static int CAMERA_REQUEST_CODE = 1;
    public final static int ALBUM_REQUEST_CODE = 2;
    public final static int CROP_REQUEST = 3;
    private int crop = 700;

    public static String SAVED_IMAGE_DIR_PATH =
            Environment.getExternalStorageDirectory().getPath()
                    + "/SportStory/camera/";
    String cameraPath;

    public void takePhoto(Activity activity){
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
        {
            cameraPath = SAVED_IMAGE_DIR_PATH + System.currentTimeMillis() + ".jpg";
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            String out_file_path = SAVED_IMAGE_DIR_PATH;
            File dir = new File(out_file_path);
            if (!dir.exists()){
                dir.mkdirs();
            }
            Uri uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", new File(cameraPath));

            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            activity.startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }else {
            Toast.makeText(activity, activity.getString(R.string.tip_confirm_has_sdcard), Toast.LENGTH_SHORT).show();
        }
    }

    public void startCropImage(Activity activity, Uri uri){
        if (uri == null || activity == null)
            return;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 使图片处于可裁剪状态
        intent.putExtra("crop", "true");
        // 裁剪框的比例（根据需要显示的图片比例进行设置）
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 让裁剪框支持缩放
        intent.putExtra("scale", true);
        // 裁剪后图片的大小（注意和上面的裁剪比例保持一致）
        intent.putExtra("outputX", crop);
        intent.putExtra("outputY", crop);
        // 传递原图路径
        File cropFile = new File(Environment.getExternalStorageDirectory() + "/crop_image.jpg");
        Uri cropImageUri = Uri.fromFile(cropFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropImageUri);
        // 设置裁剪区域的形状，默认为矩形，也可设置为原形
        //intent.putExtra("circleCrop", true);
        // 设置图片的输出格式
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        // return-data=true传递的为缩略图，小米手机默认传递大图，所以会导致onActivityResult调用失败
        intent.putExtra("return-data", false);
        // 是否需要人脸识别
        intent.putExtra("noFaceDetection", true);
        activity.startActivityForResult(intent, CROP_REQUEST);

    }


}
