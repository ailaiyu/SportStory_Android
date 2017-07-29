package cn.sportstory.android.ui.timeline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.tools.ImageLoader;
import cn.sportstory.android.ui.base.BaseRvAdapter;



/**
 * Created by Tamas on 2016/4/23.
 */
public class StoryListAdapter extends BaseRvAdapter  {


    private static final String TAG=StoryListAdapter.class.getName();
    private List<Story> mStoryList;

    private Context mContext;

    private ImageLoader mImageLoader;


    public StoryListAdapter(List<Story> storyList,Context ctx) {
        mContext=ctx;
        mStoryList=storyList;
        mImageLoader=ImageLoader.getInstance();
    }

    @Override
    public SimpleItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView;

        itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_story, viewGroup, false);
        return new SimpleItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(BaseRvViewHolder vh, int position) {
        final Story item=mStoryList.get(position);

        SimpleItemViewHolder viewHolder=(SimpleItemViewHolder)vh;

        viewHolder.tvNickname.setText(item.getNickname());

        if("".equals(item.getContent())){
            viewHolder.tvText.setVisibility(View.GONE);
        }else{
            viewHolder.tvText.setVisibility(View.VISIBLE);
            viewHolder.tvText.setText(item.getContent());
        }

        viewHolder.snplGrid.setDelegate(viewHolder);

        viewHolder.tvLikeNum.setText(item.getLikeNum()+"赞");
        viewHolder.tvCommentNum.setText(item.getCommentNum()+"评论");



        mImageLoader.displayImage(item.getAvatar(),viewHolder.ivAvatar,mContext);

        switch (item.getType()){
            case Story.TYPE_PURE_TEXT:
                viewHolder.ivSinglePic.setVisibility(View.GONE);
                viewHolder.snplGrid.setVisibility(View.GONE);
                break;
            case Story.TYPE_SINGLE_PICTUR:
                if(item.getImageUrlList().size()==1){
                    mImageLoader.displayImage(item.getImageUrlList().get(0),viewHolder.ivSinglePic,mContext);
                    viewHolder.ivSinglePic.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mContext.startActivity(BGAPhotoPreviewActivity.newIntent(mContext,null,item.getImageUrlList().get(0)));
                        }
                    });
                }
                viewHolder.ivSinglePic.setVisibility(View.VISIBLE);
                viewHolder.snplGrid.setVisibility(View.GONE);
                break;
            case Story.TYPE_MULTI_PICTUR:
                viewHolder.ivSinglePic.setVisibility(View.GONE);
                viewHolder.snplGrid.setVisibility(View.VISIBLE);
                viewHolder.snplGrid.setData(item.getImageUrlList());
                break;
        }




    }

    @Override
    public int getItemCount() {
        return (this.mStoryList!= null) ? this.mStoryList.size() : 0;
    }


    //final static
    protected  class SimpleItemViewHolder extends BaseRvViewHolder implements BGASortableNinePhotoLayout.Delegate{
        private static final int REQUEST_CODE_PHOTO_PREVIEW=1;

        @BindView(R.id.iv_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_story_nickname)
        TextView tvNickname;
        @BindView(R.id.tv_story_text)
        TextView tvText;
        @BindView(R.id.snpl_story_grid)
        BGASortableNinePhotoLayout snplGrid;
        @BindView(R.id.iv_single_pic)
        ImageView ivSinglePic;
        @BindView(R.id.tv_like_num)
        TextView tvLikeNum;
        @BindView(R.id.tv_comment_num)
        TextView tvCommentNum;

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {

        }

        @Override
        public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {

        }

        @Override
        public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
            mContext.startActivity(BGAPhotoPreviewActivity.newIntent(mContext,null,models,position));
            //mContext.startActivity(BGAPhotoPickerPreviewActivity.newIntent(mContext, snplGrid.getMaxItemCount(), models, models, position, false));
        }
    }




}