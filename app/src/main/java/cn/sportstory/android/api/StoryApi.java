package cn.sportstory.android.api;

import cn.sportstory.android.api.request.CommentRequest;
import cn.sportstory.android.api.request.LikeRequest;
import cn.sportstory.android.api.request.StoryRequest;
import cn.sportstory.android.constants.TestApiUrl;
import cn.sportstory.android.entity.Comment;
import cn.sportstory.android.entity.GenericResult;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.GenericResultWithList;
import cn.sportstory.android.entity.Like;
import cn.sportstory.android.entity.Story;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Tamas on 2017/7/9.
         */

public interface StoryApi {

    @POST("timeline")
    Flowable<GenericResult> postStory(@Header("token")String token,@Body StoryRequest storyRequest);

    @GET("timeline/{page}")
    Flowable<GenericResultWithList<Story>> getStoryList(@Header("token")String token,@Path("page") int page);

    @DELETE("timeline/{storyId}")
    Flowable<GenericResult> deleteStoryById(@Header("token")String token,@Path("storyId") long storyId);


    @POST("comment")
    Flowable<GenericResult> addComment(@Header("token")String token,@Body CommentRequest commentRequest);

    @GET("comment/{storyId}/{page}")
    Flowable<GenericResultWithList<Comment>> getCommentList(@Header("token")String token,@Path("storyId")long storyId, @Path("page")int page);


    @POST("like")
    Flowable<GenericResult> addLike(@Header("token")String token,@Body LikeRequest likeRequest);

    @GET("like/{storyId}/{page}")
    Flowable<GenericResultWithList<Like>> getLikeList(@Header("token")String token,@Path("storyId")long storyId, @Path("page")int page);





}
