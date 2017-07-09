package cn.sportstory.android.repository;

import cn.sportstory.android.api.NearbyApi;
import cn.sportstory.android.api.request.NearbyRequest;
import cn.sportstory.android.api.result.TestResult;
import cn.sportstory.android.util.RetrofitUtil;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tamas on 2017/7/6.
 */

public class UserRepository {
    private static final String TAG=UserRepository.class.getName();
    private static UserRepository sInstance;

    private NearbyApi mNearbyApi;

    private UserRepository(){
        mNearbyApi= RetrofitUtil.getRetrofit().create(NearbyApi.class);
    }
    public static UserRepository getInstance(){
        if(sInstance==null){
            synchronized (UserRepository.class){
                if(sInstance==null)sInstance=new UserRepository();
            }
        }
        return sInstance;

    }

    public Flowable<TestResult> getNearbyUserList(NearbyRequest nearbyRequest){
        return mNearbyApi.getUserNearby(nearbyRequest.getLat(),nearbyRequest.getLon());
    }



}
