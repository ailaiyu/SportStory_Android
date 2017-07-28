package cn.sportstory.android.ui.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Tamas on 2016/10/31.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    CompositeDisposable mDisposables=new CompositeDisposable();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        CompositeDisposable disposables=subscribeEvents();
        if(disposables!=null){
            mDisposables.addAll(disposables);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        if (mDisposables != null) {
            mDisposables.dispose();//取消RxBus订阅
        }
    }


    public CompositeDisposable subscribeEvents(){
        return null;
    }

    public void showProgress(String msg,boolean cancleable) {
        mProgressDialog = ProgressDialog.show(this, null, msg, true, cancleable, null);
    }

    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    public void showDialog(String title,String msg) {
        hideProgress();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(true);
        builder.create().show();
    }


}
