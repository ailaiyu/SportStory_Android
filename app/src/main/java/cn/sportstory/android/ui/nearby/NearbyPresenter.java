package cn.sportstory.android.ui.nearby;

import android.content.Context;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import cn.sportstory.android.api.request.NearbyRequest;
import cn.sportstory.android.entity.TestResult;
import cn.sportstory.android.repository.UserRepository;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Tamas on 2017/7/6.
 */

public class NearbyPresenter implements NearbyContract.Presenter {

    private static final String TAG=NearbyPresenter.class.getName();

    private NearbyContract.View mView;
    private Context mContext;
    private UserRepository mUserRepository;

    private CompositeDisposable mDisposables;

    public NearbyPresenter(NearbyContract.View view,Context ctx){
        mContext=ctx;
        mView=view;
        mView.setPresenter(this);
        mUserRepository=UserRepository.getInstance();
        mDisposables=new CompositeDisposable();

    }

    @Override
    public void unsubscribe() {
        mView=null;
        mDisposables.dispose();
    }

    @Override
    public void fetchNearbyUserList() {
        NearbyRequest nearbyRequest=new NearbyRequest();
        nearbyRequest.setLat(11.9857);
        nearbyRequest.setLon(85.855);
        nearbyRequest.setStart(System.currentTimeMillis());

        Observer observer=new Observer<TestResult>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull TestResult testResult) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Subscriber<TestResult> subscriber=new Subscriber<TestResult>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(TestResult testResult) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
        mUserRepository.getNearbyUserList(nearbyRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
