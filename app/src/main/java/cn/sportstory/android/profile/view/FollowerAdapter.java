package cn.sportstory.android.profile.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.sportstory.android.R;
import cn.sportstory.android.profile.bean.FollowerBean;
import cn.sportstory.android.tools.ImageLoader;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aaron on 2017/5/16.
 */

public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.FollowerViewHodler> {

    ArrayList<FollowerBean> followers = null;
    private Context context;

    @Override
    public FollowerViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext().getApplicationContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.follower_item, parent, false);
        FollowerViewHodler holder = new FollowerViewHodler(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FollowerViewHodler holder, int position) {
        FollowerBean follower = followers.get(position);
        holder.userId = follower.getUserId();
        holder.nickname.setText(follower.getNickname());
        ImageLoader.getInstance().displayImage(follower.getmAvatarPath(), holder.avatar, context);
    }

    @Override
    public int getItemCount() {
        return followers == null ? 0 : followers.size();
    }

    public class FollowerViewHodler extends RecyclerView.ViewHolder{
        private CircleImageView avatar;
        private String userId;
        private TextView nickname;
        private LinearLayout item;
        public FollowerViewHodler(View itemView) {
            super(itemView);
            avatar = (CircleImageView)itemView.findViewById(R.id.img_follower_item_avatar);
            nickname = (TextView)itemView.findViewById(R.id.tv_follower_item_nickname);
            item = (LinearLayout)itemView.findViewById(R.id.ll_follower_item);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2017/5/16 去主页
                    Toast.makeText(context, userId, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public FollowerAdapter(ArrayList<FollowerBean> fls){
        if (fls == null)
            return;
        followers = fls;
    }
}
