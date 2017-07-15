package cn.sportstory.android.ui.timeline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Story;
import cn.sportstory.android.tools.ImageLoader;

/**
 * Created by Tamas on 2017/7/11.
 */

public class StoryListNewAdapter extends BGARecyclerViewAdapter<Story> {

    private static final String TAG=StoryListNewAdapter.class.getName();

    private List<Story> mStoryList;
    private ImageLoader mImageLoader;
    private Context mContext;

    public StoryListNewAdapter(RecyclerView recyclerView,List<Story> storyList){
        super(recyclerView, R.layout.item_story);
        mStoryList=storyList;
        mContext=recyclerView.getContext();
        mImageLoader=ImageLoader.getInstance();
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, int position, Story model) {
        Log.i(TAG,"fillData called");
        Story item=mStoryList.get(position);

        helper.setText(R.id.tv_nickname,item.getNickName());


        if("".equals(item.getText())){
            helper.setVisibility(R.id.tv_story_text,View.GONE);
        }else{
            helper.setVisibility(R.id.tv_story_text,View.VISIBLE);
            helper.setText(R.id.tv_story_text,item.getText());
        }

        mImageLoader.displayImage(item.getAvatar(),helper.getImageView(R.id.iv_avatar),mContext);

        switch (item.getType()){
            case Story.TYPE_PURE_TEXT:
                helper.setVisibility(R.id.iv_single_pic,View.GONE);
                helper.setVisibility(R.id.snpl_story_grid,View.GONE);
                break;
            case Story.TYPE_SINGLE_PICTUR:
                if(item.getImageUrlList().size()==1)mImageLoader.displayImage(item.getImageUrlList().get(0),helper.getImageView(R.id.iv_single_pic),mContext);
                helper.setVisibility(R.id.iv_single_pic,View.VISIBLE);
                helper.setVisibility(R.id.snpl_story_grid,View.GONE);
                break;
            case Story.TYPE_MULTI_PICTUR:
                helper.setVisibility(R.id.iv_single_pic,View.GONE);
                helper.setVisibility(R.id.snpl_story_grid,View.VISIBLE);
                ((BGASortableNinePhotoLayout)helper.getView(R.id.snpl_story_grid)).setData(item.getImageUrlList());
                break;
        }
    }
}
