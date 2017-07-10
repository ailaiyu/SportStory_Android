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
        viewHolder.tvText.setText(item.getText());

        mImageLoader.displayImage(item.getAvatar(),viewHolder.ivAvatar,mContext);

        String[] imageUrls=item.getImages().split(";");

        ArrayList<String> urlList=new ArrayList<>();
        Collections.addAll(urlList,imageUrls);

        viewHolder.snplGrid.setData(urlList);




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

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }




}