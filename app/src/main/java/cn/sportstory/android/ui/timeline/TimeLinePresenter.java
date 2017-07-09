package cn.sportstory.android.ui.timeline;

import android.content.Context;
import android.util.Log;

import java.util.List;

import cn.sportstory.android.entity.GernericResultWithData;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.repository.StoryRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Tamas on 2017/7/9.
 */

public class TimeLinePresenter implements TimeLineContract.Presenter {
    private static final String TAG=TimeLinePresenter.class.getName();

    private TimeLineContract.View mView;

    private StoryRepository mStoryRepository;

    private Context mContext;

    private CompositeDisposable mDisposables;

    public TimeLinePresenter(TimeLineContract.View view,Context ctx){
        mView=view;
        mContext=ctx;
        mStoryRepository=StoryRepository.getInstance();
        mDisposables=new CompositeDisposable();
        mView.setPresenter(this);
    }


    @Override
    public void unsubscribe() {
        mDisposables.dispose();
        mView=null;
    }

    @Override
    public void fetchTimeLine() {
        Disposable disposable=mStoryRepository.getTimeLine()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GernericResultWithData<Story>>() {
                    @Override
                    public void accept(@NonNull GernericResultWithData<Story> storyGernericResultWithData) throws Exception {
                        //onNext
                        Log.i(TAG,"onNext when ftchTimeLine code:"+storyGernericResultWithData.getCode()+"  msg:"+storyGernericResultWithData.getMessage());
                        List<Story> storyList=storyGernericResultWithData.getDataList();
                        mView.onTimeLineFetched(storyList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                       //onError
                        Log.e(TAG,"onError when fetchTimeLine e:"+throwable.getMessage());
                    }
                });
        mDisposables.add(disposable);
    }
}
