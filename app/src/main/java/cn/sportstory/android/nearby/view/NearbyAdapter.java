package cn.sportstory.android.nearby.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cn.sportstory.android.R;
import cn.sportstory.android.nearby.bean.NearbyBean;
import cn.sportstory.android.profile.view.ProfileOtherActivity;
import cn.sportstory.android.tools.ImageLoader;


/**
 * Created by aaron on 2017/5/16.
 */

public class NearbyAdapter extends BaseAdapter {

    ArrayList<NearbyBean> beans = new ArrayList<>();
    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        NearbyHolder nearbyHolder = new NearbyHolder();
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext().getApplicationContext())
                    .inflate(R.layout.nearby_item, null);
            nearbyHolder.avatar = (ImageView)convertView.findViewById(R.id.img_nearby_item_avatar);
            nearbyHolder.info = (TextView)convertView.findViewById(R.id.tv_nearby_item__user_info);
            nearbyHolder.item = (LinearLayout)convertView.findViewById(R.id.ll_nearby_item);
            convertView.setTag(nearbyHolder);
        }else {
            nearbyHolder = (NearbyHolder)convertView.getTag();
        }

        NearbyBean bean = beans.get(position);
        nearbyHolder.info.setText(beans.get(position).getNickname());

        ImageLoader.getInstance().displayImage(bean.getAvatarPath(),
                nearbyHolder.avatar, parent.getContext().getApplicationContext());
        nearbyHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("userId", beans.get(position).getUserId());
                intent.putExtras(bundle);
                intent.setClass(parent.getContext(), ProfileOtherActivity.class);
                parent.getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    private class NearbyHolder {
        private ImageView avatar;
        private TextView info;
        private LinearLayout item;
    }

    public void appendUser(ArrayList<NearbyBean> users){
        if (users == null || users.size() == 0)
            return;
        for (int i = 0; i < users.size(); i ++){
            beans.add(users.get(i));
        }
        notifyDataSetChanged();
    }
}
