package cn.sportstory.android.repository;

import cn.sportstory.android.api.StoryApi;
import cn.sportstory.android.api.request.StoryRequest;
import cn.sportstory.android.entity.Comment;
import cn.sportstory.android.entity.GenericResult;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.GenericResultWithList;
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
        mStoryApi= RetrofitUtil.getRetrofit().create(StoryApi.class);
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

    public Flowable<GenericResultWithList<Story>> getTimeLine(String token,int page){
        return mStoryApi.getStoryList(token,page);
    }
    public Flowable<GenericResultWithList<Comment>> getCommentByStoryId(){
        return null;
    }
    public Flowable<GenericResult> postStory(String token, StoryRequest storyRequest){
        return mStoryApi.postStory(token,storyRequest);
    }



}
