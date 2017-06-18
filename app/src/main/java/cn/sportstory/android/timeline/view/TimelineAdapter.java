package cn.sportstory.android.timeline.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.sportstory.android.R;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.tools.ImageLoader;

/**
 * Created by aaron on 2017/5/16.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    ArrayList<TimelineBean> timelines = new ArrayList<>();

    private Context context;

    public TimelineAdapter() {
        TimelineBean timelineBean = new TimelineBean();
        timelineBean.setCreate_time("28/04");
        timelineBean.setLike(null);
        timelineBean.setComment(null);
        timelineBean.setContent("明天加油！");
        timelines.add(timelineBean);
    }

    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext().getApplicationContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_item, parent, false);
        return new TimelineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {
        TimelineBean timelineBean = timelines.get(position);
        holder.date.setText(timelineBean.getCreate_time());
        holder.content.setText(timelineBean.getContent());
        holder.likeCount.setText("10");
        holder.commentCount.setText("10");
    }

    @Override
    public int getItemCount() {
        return timelines.size();
    }

    public class TimelineViewHolder extends RecyclerView.ViewHolder {
        private TextView date;
        private TextView content;
        private GridView picContent;
        private TextView likeCount;
        private TextView commentCount;

        public TimelineViewHolder(View itemView) {
            super(itemView);
            date = (TextView)itemView.findViewById(R.id.tv_timeline_item_date);
            content = (TextView)itemView.findViewById(R.id.tv_timeline_item_content);
            picContent = (GridView) itemView.findViewById(R.id.gv_timeline_item_pic);
            likeCount = (TextView)itemView.findViewById(R.id.tv_timeline_item_like_count);
            commentCount = (TextView)itemView.findViewById(R.id.tv_timeline_item_comment_count);
        }
    }
}
