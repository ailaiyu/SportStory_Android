package cn.sportstory.android.ui.home;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Tamas on 2017/7/16.
 */

public class HomePresneter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private Context mContext;
    private CompositeDisposable mDisposable;

    HomePresneter(HomeContract.View view ,Context ctx){
        mView=view;
        mContext=ctx;
        mView.setPresenter(this);
    }

    @Override
    public void unsubscribe() {
        mDisposable.dispose();
    }
}
