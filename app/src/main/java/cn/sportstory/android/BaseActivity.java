package cn.sportstory.android;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.umeng.analytics.MobclickAgent;

import cn.sportstory.android.common.PermissionCode;
import cn.sportstory.android.common.service.LocationService;

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
            if (ContextCompat.checkSelfPermission(this,  android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                //开启定位service
                Intent intent = new Intent();
                intent.setClass(this.getApplicationContext(), LocationService.class);
                startService(intent);
            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PermissionCode.ACCESS_COARSE_LOCATION_REQUEST_CODE);
            }
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        SportStoryApp.sActivityCount --;
        if (SportStoryApp.sActivityCount <= 0)
        {
            //停止定位service
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
}
