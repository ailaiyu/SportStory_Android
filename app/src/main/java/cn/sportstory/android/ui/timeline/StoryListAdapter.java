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
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.tools.ImageLoader;
import cn.sportstory.android.ui.base.BaseRvAdapter;



/**
 * Created by Tamas on 2016/4/23.
 */
public class StoryListAdapter extends BaseRvAdapter {


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
        Story item=mStoryList.get(position);

        SimpleItemViewHolder viewHolder=(SimpleItemViewHolder)vh;

        viewHolder.tvNickname.setText(item.getNickName());

        if("".equals(item.getText())){
            viewHolder.tvText.setVisibility(View.GONE);
        }else{
            viewHolder.tvText.setVisibility(View.VISIBLE);
            viewHolder.tvText.setText(item.getText());
        }

        mImageLoader.displayImage(item.getAvatar(),viewHolder.ivAvatar,mContext);

        switch (item.getType()){
            case Story.TYPE_PURE_TEXT:
                viewHolder.ivSinglePic.setVisibility(View.GONE);
                viewHolder.snplGrid.setVisibility(View.GONE);
                break;
            case Story.TYPE_SINGLE_PICTUR:
                if(item.getImageUrlList().size()==1)mImageLoader.displayImage(item.getImageUrlList().get(0),viewHolder.ivSinglePic,mContext);
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
    protected  class SimpleItemViewHolder extends BaseRvViewHolder {


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

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }




}