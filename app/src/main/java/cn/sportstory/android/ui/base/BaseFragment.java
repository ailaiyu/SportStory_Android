package cn.sportstory.android.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tamas on 2016/11/2.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG=BaseFragment.class.getName();
    private CompositeDisposable mDisposables;

    //如果复写，必须super
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Disposable disposable=subscribeEvents();
        if(disposable!=null)Log.i(TAG,"Rx订阅啦");
        addSubscription(disposable);
    }

    //如果复写，必须super
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mDisposables != null) {
            mDisposables.dispose();
        }
    }

    //如果复写，必须super
    @Override
    public void onDestroy() {
        super.onDestroy();
        //RefWatcher refWatcher = AomsApplication.getRefWatcher(getActivity());
        //refWatcher.watch(this);
    }

    protected Disposable subscribeEvents() {
        return null;
    }

    private void addSubscription(Disposable disposable) {
        if (disposable == null) return;
        if (mDisposables == null) {
            mDisposables = new CompositeDisposable();
        }
        mDisposables.add(disposable);
    }
}
