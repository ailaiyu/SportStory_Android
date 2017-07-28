package cn.sportstory.android.ui.addmoment;

import android.content.Context;
import android.util.Log;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;

import org.json.JSONObject;

import java.util.List;
import java.util.UUID;

import cn.sportstory.android.entity.CurrentAccount;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.QiniuFactory;
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

    public AddMomentPresenter(AddMomentContract.View view, Context ctx){
        mView=view;
        mContext=ctx;
        mView.setPresenter(this);
        mDisposables=new CompositeDisposable();
        mUserRepository=UserRepository.getInstance();
        mCurrentAccount=CurrentAccount.getInstance(mContext);
    }

    @Override
    public void unsubscribe() {
        mDisposables.dispose();
        mView=null;
    }

    @Override
    public void postMoment(List<String> imagePathList, String content) {
        getQiniuToken(imagePathList);
    }

    /*
    获取气牛Token
     */
    private void getQiniuToken(final List<String >imagePathList){
        Disposable disposable=mUserRepository.getQiniuTimelineToken(mCurrentAccount.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenericResultWithData<String>>() {
                    @Override
                    public void accept(@NonNull GenericResultWithData<String> stringGenericResultWithData) throws Exception {
                        String qiniuToken=stringGenericResultWithData.getData();
                        uploadImagesToQiniuServer(imagePathList,qiniuToken);
                    }
                });
        mDisposables.add(disposable);
    }

    /*
    上传图片到七牛服务器
     */
    private void uploadImagesToQiniuServer(List<String>imagePathList,String qiniuToken){
        UploadManager uploadManager=QiniuFactory.getUploadManager();
        for(String imagePath:imagePathList){
            String key= UUID.randomUUID().toString();
            uploadManager.put(imagePath, null, qiniuToken, new UpCompletionHandler() {
                @Override
                public void complete(String s, ResponseInfo responseInfo, JSONObject jsonObject) {
                    if(responseInfo.isOK()){
                        Log.i(TAG,"上传完成，key："+s);
                    }else{
                        Log.e(TAG,"上传失败，json："+jsonObject.toString());
                    }

                }
            },null);
        }
    }
}
