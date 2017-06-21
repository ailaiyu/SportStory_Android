package cn.sportstory.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.WindowManager;

import com.umeng.analytics.MobclickAgent;

import cn.sportstory.android.common.service.LocationService;
import cn.sportstory.android.common.tools.PermissionUtils;

/**
 * Created by zlg on 17-3-24.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    protected void onStart() {
        SportStoryApp.sActivityCount ++;
        if (SportStoryApp.sActivityCount == 1)
        {
            if (isPermissionGranted(PermissionUtils.REQUEST_ACCESS_LOCATION)) {
                //开启定位service
                Intent intent = new Intent();
                intent.setClass(this.getApplicationContext(), LocationService.class);
                startService(intent);
            }else {
                requestPermission(PermissionUtils.REQUEST_ACCESS_LOCATION, PermissionUtils.REQUEST_CODE_ACCESS_LOCATION);
            }
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        SportStoryApp.sActivityCount --;
        if (SportStoryApp.sActivityCount <= 0)
        {
            Intent intent = new Intent();
            intent.setClass(this.getApplicationContext(), LocationService.class);
            stopService(intent);
        }
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void requestPermission(final String permissionName, final int requestCode){
        if (!isPermissionGranted(permissionName)){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    permissionName)){
                String explanation = PermissionUtils.GetExplanationByRequestCode(this, requestCode);
                if (!TextUtils.isEmpty(explanation)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.
                            setTitle(getString(R.string.tip))
                            .setMessage(explanation)
                            .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(BaseActivity.this, new String[]{permissionName}, requestCode);

                                }
                            }).create().show();
                }
            }else {
                ActivityCompat.requestPermissions(this, new String[]{permissionName}, requestCode);
            }
        };

    }

    public boolean isPermissionGranted(String permission){
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PermissionUtils.REQUEST_CODE_ACCESS_LOCATION:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this)
                            .setTitle(getString(R.string.tip)).setMessage("你可以在设置中打开权限")
                            .setPositiveButton(getString(R.string.confirm),
                                    new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    builder.create().show();
                }
        }
    }


}
