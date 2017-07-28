package cn.sportstory.android.repository;

import cn.sportstory.android.api.AccountApi;
import cn.sportstory.android.api.NearbyApi;
import cn.sportstory.android.api.QiniuApi;
import cn.sportstory.android.api.request.LoginRequest;
import cn.sportstory.android.api.request.NearbyRequest;
import cn.sportstory.android.entity.Account;
import cn.sportstory.android.entity.CurrentAccount;
import cn.sportstory.android.entity.GenericResult;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.TestResult;
import cn.sportstory.android.util.RetrofitUtil;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;

/**
 * Created by Tamas on 2017/7/6.
 */

public class UserRepository {
    private static final String TAG=UserRepository.class.getName();
    private static UserRepository sInstance;

    private AccountApi mAccountApi;
    private QiniuApi mQiniuApi;


    private UserRepository(){

        mAccountApi=RetrofitUtil.getRetrofit().create(AccountApi.class);
        mQiniuApi=RetrofitUtil.getRetrofit().create(QiniuApi.class);
    }
    public static UserRepository getInstance(){
        if(sInstance==null){
            synchronized (UserRepository.class){
                if(sInstance==null)sInstance=new UserRepository();
            }
        }
        return sInstance;
    }

    public Flowable<GenericResultWithData<Account>> loginWithPhone(LoginRequest loginRequest){
        return mAccountApi.loginWithPhone(loginRequest);
    }

    public Flowable<GenericResultWithData<Account>> checkValid(String token){
        return mAccountApi.getUserInfo(token);
    }

    /*
    获取七牛Timeline仓库Token
     */
    public Flowable<GenericResultWithData<String>> getQiniuTimelineToken(String token){
        return mQiniuApi.getTimelineToken(token);
    }

    /*
    获取七牛Background仓库Token
     */
    public Flowable<GenericResultWithData<String>> getQiniuBackgroundToken(String token){
        return mQiniuApi.getTimelineToken(token);
    }

    /*
    获取七牛Avatar仓库Token
     */
    public Flowable<GenericResultWithData<String>> getQiniuAvatarToken(String token){
        return mQiniuApi.getTimelineToken(token);
    }

    public Flowable<Boolean> applyAccountToSharedPreference(final CurrentAccount currentAccount, final Account account){

        return Flowable.create(new FlowableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Boolean> e) throws Exception {
                currentAccount.reset(account);
                e.onNext(true);
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER);
    }




}
