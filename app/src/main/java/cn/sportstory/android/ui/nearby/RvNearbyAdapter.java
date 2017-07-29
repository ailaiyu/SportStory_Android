package cn.sportstory.android.ui.nearby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.SimpleUserInfo;
import cn.sportstory.android.entity.SimpleUserInfoWithLocation;
import cn.sportstory.android.tools.ImageLoader;
import cn.sportstory.android.ui.base.BaseRvAdapter;
import retrofit2.http.Body;

/**
 * Created by Tamas on 2017/7/29.
 */

public class RvNearbyAdapter extends BaseRvAdapter {
    private List<SimpleUserInfoWithLocation> mNearbyUserList;
    private Context mContext;
    private ImageLoader mImageLoader;

    public RvNearbyAdapter(List<SimpleUserInfoWithLocation> userInfoList, Context ctx){
        mNearbyUserList=userInfoList;
        mContext=ctx;
        mImageLoader=ImageLoader.getInstance();
    }

    @Override
    public BaseRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nearby_user, parent, false);
        return new RvNearbyAdapter.SimpleItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseRvViewHolder holder, int position) {
        final SimpleUserInfo item=mNearbyUserList.get(position);
        RvNearbyAdapter.SimpleItemViewHolder viewHolder=(RvNearbyAdapter.SimpleItemViewHolder)holder;
        //viewHolder.ivAvatar.setImageResource(R.mipmap.avatar);
        mImageLoader.displayImage(item.getAvatarUrl(),viewHolder.ivAvatar,mContext);
        viewHolder.tvDistance.setText("5KM");
        viewHolder.tvNickname.setText(item.getNickname());
        viewHolder.ivSport1.setImageResource(R.mipmap.pingpong_free);
        viewHolder.ivSport2.setImageResource(R.mipmap.baolingqiu_free);
        viewHolder.ivSport3.setImageResource(R.mipmap.juzhong_free);
    }

    @Override
    public int getItemCount() {
        return (this.mNearbyUserList!= null) ? this.mNearbyUserList.size() : 0;
    }

    protected  class SimpleItemViewHolder extends BaseRvViewHolder{

        @BindView(R.id.iv_nearby_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_nearby_nickname)
        TextView tvNickname;
        @BindView(R.id.tv_nearby_distance)
        TextView tvDistance;
        @BindView(R.id.iv_nearby_sport1)
        ImageView ivSport1;
        @BindView(R.id.iv_nearby_sport2)
        ImageView ivSport2;
        @BindView(R.id.iv_nearby_sport3)
        ImageView ivSport3;

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
