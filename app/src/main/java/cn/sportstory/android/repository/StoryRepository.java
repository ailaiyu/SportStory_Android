package cn.sportstory.android.repository;

import cn.sportstory.android.api.StoryApi;
import cn.sportstory.android.entity.Comment;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.util.RetrofitUtil;
import io.reactivex.Flowable;

/**
 * Created by Tamas on 2017/7/9.
 */

public class StoryRepository {
    private static final String TAG=StoryRepository.class.getName();

    private static StoryRepository sInstance;

    private StoryApi mStoryApi;

    private StoryRepository(){
        mStoryApi= RetrofitUtil.getTestRetrofit().create(StoryApi.class);
    }
    public static StoryRepository getInstance(){
        if(sInstance==null){
            synchronized (StoryRepository.class){
                if(sInstance==null){
                    sInstance=new StoryRepository();
                }
            }
        }
        return sInstance;
    }

    public Flowable<GenericResultWithData<Story>> getTimeLine(){
        return mStoryApi.getTimeLine();
    }
    public Flowable<GenericResultWithData<Story>> getTimeLineMoreOnePage(){
        return mStoryApi.getTimeLinePage2();
    }
    public Flowable<GenericResultWithData<Comment>> getCommentByStoryId(){
        return mStoryApi.getComment();
    }



}
