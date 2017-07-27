package cn.sportstory.android.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    public void showMsg(String msg,boolean cancleable) {
        mProgressDialog = ProgressDialog.show(this, null, msg, true, cancleable, null);
    }

    public void hideMsg() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }


}
