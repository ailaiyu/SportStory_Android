package cn.sportstory.android.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tamas on 2016/10/31.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 如果Android版本大于等于KitKat，使用沉浸式状态栏
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {// KITKAT以上版本支持沉浸式状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);// 状态栏沉浸
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//导航条沉浸
        }
        */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume(){
        //横屏
        super.onResume();

    }


    protected void showMsg(String msg,boolean cancleable) {
        mProgressDialog = ProgressDialog.show(this, null, msg, true, cancleable, null);
    }

    protected void hideMsg() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }




}
