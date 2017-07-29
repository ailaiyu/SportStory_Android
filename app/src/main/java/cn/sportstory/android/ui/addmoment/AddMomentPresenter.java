package cn.sportstory.android.ui.addmoment;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.sportstory.android.api.request.StoryRequest;
import cn.sportstory.android.entity.CurrentAccount;
import cn.sportstory.android.entity.GenericResult;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.QiniuFactory;
import cn.sportstory.android.entity.QiniuResult;
import cn.sportstory.android.repository.StoryRepository;
import cn.sportstory.android.repository.UserRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Tamas on 2017/7/28.
 */

public class AddMomentPresenter implements AddMomentContract.Presenter {

    private static final String TAG=AddMomentPresenter.class.getName();

    private CompositeDisposable mDisposables;

    private AddMomentContract.View mView;
    private Context mContext;

    private CurrentAccount mCurrentAccount;

    private UserRepository mUserRepository;
    private StoryRepository mStoryRepository;

    private int mValidSize;

    public AddMomentPresenter(AddMomentContract.View view, Context ctx){
        mView=view;
        mContext=ctx;
        mView.setPresenter(this);
        mDisposables=new CompositeDisposable();
        mUserRepository=UserRepository.getInstance();
        mCurrentAccount=CurrentAccount.getInstance(mContext);
        mStoryRepository=StoryRepository.getInstance();
    }

    @Override
    public void unsubscribe() {
        mDisposables.dispose();
        mView=null;
    }

    @Override
    public void postMoment(List<String> imagePathList, String content) {
        getQiniuToken(imagePathList,content);
    }

    /*
    获取气牛Token
     */
    private void getQiniuToken(final List<String >imagePathList, final String content){
        Disposable disposable=mUserRepository.getQiniuTimelineToken(mCurrentAccount.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenericResultWithData<String>>() {
                    @Override
                    public void accept(@NonNull GenericResultWithData<String> stringGenericResultWithData) throws Exception {
                        String qiniuToken=stringGenericResultWithData.getData();
                        uploadImagesToQiniuServer(imagePathList,qiniuToken,content);
                    }
                });
        mDisposables.add(disposable);
    }

    /*
    上传图片到七牛服务器
     */
    private void uploadImagesToQiniuServer(List<String>imagePathList, final String qiniuToken, final String content){
        if(imagePathList.size()==0){//没有图片的情况
            StoryRequest storyRequest=new StoryRequest();
            storyRequest.setImageUrls(";");
            storyRequest.setText(content);
            uploadStoryToSportStoryServer(storyRequest);
            return;
        }
        final List<String> keyList=new ArrayList<>();
        mValidSize=imagePathList.size();
        //TODO 对keyList排序，否则图片顺序不是用户事先预想好的
        UploadManager uploadManager=QiniuFactory.getUploadManager();
        for(String imagePath:imagePathList){
            File imageFile=new File(imagePath);
            if(!imageFile.exists())mValidSize--;
            String key= UUID.randomUUID().toString();
            uploadManager.put(imagePath, null, qiniuToken, new UpCompletionHandler() {
                @Override
                public void complete(String s, ResponseInfo responseInfo, JSONObject jsonObject) {
                    if(responseInfo.isOK()){
                        QiniuResult qiniuResult=new Gson().fromJson(jsonObject.toString(),QiniuResult.class);
                        keyList.add(qiniuResult.getKey());
                        if(keyList.size()==mValidSize){
                            StoryRequest storyRequest=new StoryRequest();
                            StringBuilder sb=new StringBuilder();
                            for(String key:keyList){
                                sb.append(key+";");
                            }
                            storyRequest.setImageUrls(sb.toString());
                            storyRequest.setText(content);
                            uploadStoryToSportStoryServer(storyRequest);
                        }
                    }else{
                        Log.e(TAG,"上传失败，json：");
                        mValidSize--;
                    }

                }
            },null);
        }
    }

    private void uploadStoryToSportStoryServer(StoryRequest storyRequest){

        mStoryRepository.postStory(mCurrentAccount.getToken(),storyRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenericResult>() {
                    @Override
                    public void accept(@NonNull GenericResult genericResult) throws Exception {
                        if (genericResult.getStatus() == 1) {
                            //成功
                            Log.i(TAG, "发布动态成功");
                            mView.onPostMomentSuccess();
                        } else {
                            Log.e(TAG, "发布动态失败");
                            mView.onPostMomentFail(genericResult.getMessage());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG,"IO异常"+throwable.getMessage());
                        mView.onPostMomentFail("IO异常");
                    }
                });

    }
}
