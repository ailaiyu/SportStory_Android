package cn.sportstory.android.ui.login.password;

import android.content.Context;
import android.util.Log;

import cn.sportstory.android.api.request.LoginRequest;
import cn.sportstory.android.entity.Account;
import cn.sportstory.android.entity.CurrentAccount;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.repository.UserRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Tamas on 2017/7/27.
 */

public class PasswordLoginPresenter implements PasswordLoginContract.Presenter {
    private static final String TAG=PasswordLoginPresenter.class.getName();
    private PasswordLoginContract.View mView;
    private Context mContext;

    private UserRepository mUserRepository;
    private CompositeDisposable mDisposabals;


    public PasswordLoginPresenter(PasswordLoginContract.View view ,Context ctx ){
        mView=view;
        mContext=ctx;
        mView.setPresenter(this);
        mUserRepository=UserRepository.getInstance();
        mDisposabals=new CompositeDisposable();
    }

    @Override
    public void unsubscribe() {
        mDisposabals.dispose();
        mView=null;
    }

    @Override
    public void login(final String account, String password) {
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setAccountType(LoginRequest.TYPE_PHONE);
        loginRequest.setPhone(account);
        loginRequest.setPassword(password);
        mUserRepository.loginWithPhone(loginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenericResultWithData<Account>>() {
                    @Override
                    public void accept(@NonNull GenericResultWithData<Account> accountGenericResultWithData) throws Exception {
                        Log.i(TAG,"onNext when login status:"+accountGenericResultWithData.getStatus());
                        if (accountGenericResultWithData.getStatus() == 1) {
                            applyAccountToSharePreference(accountGenericResultWithData.getData());
                        }else{
                            mView.onLoginFail(""+accountGenericResultWithData.getMessage());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG,"onError when login e:"+throwable.getMessage());
                        mView.onLoginFail("IO异常");
                    }
                });

    }

    private void applyAccountToSharePreference(Account account){
        Disposable disposable=mUserRepository.applyAccountToSharedPreference(CurrentAccount.getInstance(mContext),account)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        mView.onLoginSuccess();
                    }
                });
        mDisposabals.add(disposable);

    }
}
