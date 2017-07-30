package cn.sportstory.android.ui.timeline.detail;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Comment;
import cn.sportstory.android.tools.ImageLoader;
import cn.sportstory.android.ui.base.BaseRvAdapter;

/**
 * Created by Tamas on 2017/7/15.
 */

public class DetailCommentAdapter extends BaseRvAdapter {

    private List<Comment> mCommentList;
    private Context mContext;
    private ImageLoader mImageLoader;

    public DetailCommentAdapter(List<Comment> commentList,Context ctx){
        mCommentList=commentList;
        mContext=ctx;
        mImageLoader=ImageLoader.getInstance();
    }

    @Override
    public SimpleItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView;

        itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_story_comment, viewGroup, false);
        return new DetailCommentAdapter.SimpleItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseRvViewHolder holder, int position) {
        Comment item=mCommentList.get(position);
        SimpleItemViewHolder viewHolder=(SimpleItemViewHolder)holder;

        viewHolder.tvContent.setText(Html.fromHtml(getContent(item.getToName(),item.getContent())));
        viewHolder.tvFrom.setText(item.getFromName());
        mImageLoader.displayImage(item.getAvatarUrl(),viewHolder.ivAvatar,mContext);

    }

    @Override
    public int getItemCount() {
        return mCommentList.size();
    }




    private String getContent(String to,String content){
        if(to==null||"".equals(to)) return content;
        else return "回复<font color='#FF0000'>"+to+"</font>"+content;
    }

    class SimpleItemViewHolder extends BaseRvViewHolder{

        @BindView(R.id.iv_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_from)
        TextView tvFrom;
        @BindView(R.id.tv_content)
        TextView tvContent;

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
