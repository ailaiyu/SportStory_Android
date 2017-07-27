package cn.sportstory.android.ui.timeline;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.sportstory.android.entity.GenericResultWithData;
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
                .subscribe(new Consumer<GenericResultWithData<Story>>() {
                    @Override
                    public void accept(GenericResultWithData<Story> storyGernericResultWithData) throws Exception {
                        List<Story> storyList=storyGernericResultWithData.getDataList();
                        if(storyList==null)storyList=new ArrayList<Story>();
                        for(Story item:storyList){
                            ArrayList<String> imageUrlList=new ArrayList<String>();
                            String images=item.getImages();
                            if("".equals(images))images=";";
                            if(images==null)images=";";
                            String[] imageArray=images.split(";");
                            Collections.addAll(imageUrlList,imageArray);
                            item.setImageUrlList(imageUrlList);
                            switch (imageUrlList.size()){//设置动态类型 纯文字、单图、多图
                                case 0:
                                    item.setType(Story.TYPE_PURE_TEXT);
                                    break;
                                case 1:
                                    item.setType(Story.TYPE_SINGLE_PICTUR);
                                    break;
                                default:
                                    item.setType(Story.TYPE_MULTI_PICTUR);
                                    break;
                            }
                        }
                        mView.onTimeLineFetched(storyList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                       //onError
                        //TODO 提示获取动态列表失败
                        Log.e(TAG,"onError when fetchTimeLine e:"+throwable.getMessage());
                    }
                });
        mDisposables.add(disposable);
    }

    @Override
    public void fetchTimeLineMoreOnePage() {
        Disposable disposable=mStoryRepository.getTimeLineMoreOnePage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenericResultWithData<Story>>() {
                    @Override
                    public void accept(GenericResultWithData<Story> storyGernericResultWithData) throws Exception {
                        List<Story> storyList=storyGernericResultWithData.getDataList();
                        if(storyList==null)storyList=new ArrayList<Story>();
                        for(Story item:storyList){
                            ArrayList<String> imageUrlList=new ArrayList<String>();
                            String images=item.getImages();
                            if("".equals(images))images=";";
                            if(images==null)images=";";
                            String[] imageArray=images.split(";");
                            Collections.addAll(imageUrlList,imageArray);
                            item.setImageUrlList(imageUrlList);
                            switch (imageUrlList.size()){//设置动态类型 纯文字、单图、多图
                                case 0:
                                    item.setType(Story.TYPE_PURE_TEXT);
                                    break;
                                case 1:
                                    item.setType(Story.TYPE_SINGLE_PICTUR);
                                    break;
                                default:
                                    item.setType(Story.TYPE_MULTI_PICTUR);
                                    break;
                            }
                        }
                        mView.onTimeLineMoreOnePageFetched(storyList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        //onError
                        //TODO 提示获取动态列表失败
                        Log.e(TAG,"onError when fetchTimeLine e:"+throwable.getMessage());
                    }
                });
        mDisposables.add(disposable);
    }
}
