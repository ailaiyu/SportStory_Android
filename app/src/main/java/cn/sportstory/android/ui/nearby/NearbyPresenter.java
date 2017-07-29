package cn.sportstory.android.ui.nearby;

import android.content.Context;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import cn.sportstory.android.api.request.NearbyRequest;
import cn.sportstory.android.entity.CurrentAccount;
import cn.sportstory.android.entity.GenericResultWithList;
import cn.sportstory.android.entity.SimpleUserInfoWithLocation;
import cn.sportstory.android.entity.TestResult;
import cn.sportstory.android.repository.UserRepository;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Tamas on 2017/7/6.
 */

public class NearbyPresenter implements NearbyContract.Presenter {

    private static final String TAG=NearbyPresenter.class.getName();

    private NearbyContract.View mView;
    private Context mContext;
    private UserRepository mUserRepository;

    private CurrentAccount mCurrentAccount;
    private CompositeDisposable mDisposables;

    public NearbyPresenter(NearbyContract.View view,Context ctx){
        mContext=ctx;
        mView=view;
        mView.setPresenter(this);
        mUserRepository=UserRepository.getInstance();
        mDisposables=new CompositeDisposable();
        mCurrentAccount=CurrentAccount.getInstance(mContext);

    }

    @Override
    public void unsubscribe() {
        mView=null;
        mDisposables.dispose();
    }

    @Override
    public void fetchNearbyUserList() {
        Disposable disposable=mUserRepository.getNearbyUserList(mCurrentAccount.getToken(),25,25,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenericResultWithList<SimpleUserInfoWithLocation>>() {
                    @Override
                    public void accept(@NonNull GenericResultWithList<SimpleUserInfoWithLocation> result) throws Exception {
                        if(result.getStatus()==1){
                            mView.onNearbyUserListFetched(result.getList());
                        }
                    }
                });
        mDisposables.add(disposable);
    }
}
