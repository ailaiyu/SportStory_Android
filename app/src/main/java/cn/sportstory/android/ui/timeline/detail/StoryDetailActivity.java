package cn.sportstory.android.ui.timeline.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Comment;
import cn.sportstory.android.entity.CurrentAccount;
import cn.sportstory.android.entity.GenericResultWithData;
import cn.sportstory.android.entity.GenericResultWithList;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.repository.StoryRepository;
import cn.sportstory.android.tools.ImageLoader;
import cn.sportstory.android.ui.base.BaseActivity;
import cn.sportstory.android.ui.timeline.TimeLineFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Tamas on 2017/7/14.
 * 动态详情
 */

public class StoryDetailActivity extends BaseActivity {
    private static final String TAG=StoryDetailActivity.class.getName();

    private ImageLoader mImageLoader;
    private Context mContext;

    private CurrentAccount mCurrentAccount;

    private List<Comment> mCommentList;

    private StoryRepository mStoryRepository;

    private DetailCommentAdapter mAdapter;

    private CompositeDisposable mDisposables;

    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.tv_story_nickname)
    TextView mTvNickname;
    @BindView(R.id.tv_story_text)
    TextView mTvText;
    @BindView(R.id.snpl_story_grid)
    BGASortableNinePhotoLayout mSnplGrid;
    @BindView(R.id.iv_single_pic)
    ImageView mIvSinglePic;
    @BindView(R.id.tv_like_num)
    TextView mTvLikeNum;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.rv_comment)
    RecyclerView mRvComment;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private Story mStory;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        ButterKnife.bind(this);

        mStoryRepository=StoryRepository.getInstance();
        mDisposables=new CompositeDisposable();
        mCurrentAccount=CurrentAccount.getInstance(getApplicationContext());

        mImageLoader=ImageLoader.getInstance();
        mContext=getApplicationContext();
        mCommentList=new ArrayList<>();

        mAdapter=new DetailCommentAdapter(mCommentList,getApplicationContext());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        mRvComment.setLayoutManager(layoutManager);
        mRvComment.setAdapter(mAdapter);
        if(savedInstanceState==null){
            mStory=(Story)getIntent().getSerializableExtra(TimeLineFragment.KEY_STORY);
        }else{
            mStory=(Story)savedInstanceState.getSerializable(TimeLineFragment.KEY_STORY);
        }

        mImageLoader.displayImage(mStory.getAvatar(),mIvAvatar,mContext);
        mTvNickname.setText(mStory.getNickname());
        mTvLikeNum.setText(mStory.getLikeNum()+"赞");
        mTvCommentNum.setText(mStory.getCommentNum()+"评论");
        if("".equals(mStory.getContent())){
            mTvText.setVisibility(View.GONE);
        }else{
            mTvText.setVisibility(View.VISIBLE);
            mTvText.setText(mStory.getContent());
        }
        switch (mStory.getType()){
            case Story.TYPE_PURE_TEXT:
                mIvSinglePic.setVisibility(View.GONE);
                mSnplGrid.setVisibility(View.GONE);
                break;
            case Story.TYPE_SINGLE_PICTUR:
                if(mStory.getImageUrlList().size()==1)mImageLoader.displayImage(mStory.getImageUrlList().get(0),mIvSinglePic,mContext);
                mIvSinglePic.setVisibility(View.VISIBLE);
                mSnplGrid.setVisibility(View.GONE);
                break;
            case Story.TYPE_MULTI_PICTUR:
                mIvSinglePic.setVisibility(View.GONE);
                mSnplGrid.setVisibility(View.VISIBLE);
                mSnplGrid.setData(mStory.getImageUrlList());
                break;
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fetchCommentList();

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable(TimeLineFragment.KEY_STORY,mStory);
    }

    private void fetchCommentList(){
        Disposable disposable=mStoryRepository.getCommentByStoryId(mCurrentAccount.getToken(),mStory.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenericResultWithList<Comment>>() {
                    @Override
                    public void accept(@NonNull GenericResultWithList<Comment> commentGernericResultWithList) throws Exception {
                        List<Comment> commentList=commentGernericResultWithList.getList();
                        if(commentList==null)commentList=new ArrayList<Comment>();
                        onCommentListFetched(commentList);
                        Log.i(TAG,"onNext when fetchCommentList size:"+commentList.size());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG,"onError when fetchCommentList e:"+throwable.getMessage());
                    }
                });
        mDisposables.add(disposable);
    }

    private void onCommentListFetched(List<Comment> commentList){
        Log.i(TAG,"onCommentListFetched size:"+commentList.size());
        mCommentList.clear();
        mCommentList.addAll(commentList);
        mAdapter.notifyDataSetChanged();
    }


}
