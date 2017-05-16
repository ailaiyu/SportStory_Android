package cn.sportstory.android.timeline.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aaron on 2017/5/16.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    ArrayList<TimelineBean> timelines = new ArrayList<>();

    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TimelineViewHolder extends RecyclerView.ViewHolder {
        private TextView date;
        private TextView content;
        private ImageView pic;
        private TextView likeCount;
        private TextView commentCount;

        public TimelineViewHolder(View itemView) {
            super(itemView);
        }
    }
}
