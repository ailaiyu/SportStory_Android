package cn.sportstory.android.ui.timeline;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.tools.ImageLoader;
import cn.sportstory.android.ui.base.BaseActivity;

/**
 * Created by Tamas on 2017/7/14.
 * 动态详情
 */

public class StoryDetailActivity extends BaseActivity {

    private ImageLoader mImageLoader;
    private Context mContext;

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

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private Story mStory;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        ButterKnife.bind(this);

        mImageLoader=ImageLoader.getInstance();
        mContext=getApplicationContext();

        if(savedInstanceState==null){
            mStory=(Story)getIntent().getSerializableExtra(TimeLineFragment.KEY_STORY);
        }else{
            mStory=(Story)savedInstanceState.getSerializable(TimeLineFragment.KEY_STORY);
        }

        mImageLoader.displayImage(mStory.getAvatar(),mIvAvatar,mContext);
        mTvNickname.setText(mStory.getNickName());
        mTvLikeNum.setText(mStory.getLikeNum()+"赞");
        mTvCommentNum.setText(mStory.getCommentNum()+"评论");
        if("".equals(mStory.getText())){
            mTvText.setVisibility(View.GONE);
        }else{
            mTvText.setVisibility(View.VISIBLE);
            mTvText.setText(mStory.getText());
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

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable(TimeLineFragment.KEY_STORY,mStory);
    }


}
