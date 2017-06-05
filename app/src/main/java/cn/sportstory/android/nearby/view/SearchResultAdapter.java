package cn.sportstory.android.nearby.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import cn.sportstory.android.R;
import cn.sportstory.android.common.bean.QueryUserBean;
import cn.sportstory.android.profile.view.ProfileOtherActivity;
import cn.sportstory.android.tools.ImageLoader;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aaron on 2017/6/5.
 */

public class SearchResultAdapter extends BaseAdapter {
    private List<QueryUserBean> users;

    public SearchResultAdapter(List<QueryUserBean> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users == null ? 0 : users.size();
    }

    @Override
    public QueryUserBean getItem(int position) {
        return (users == null || users.size() == 0) ? null : users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final QueryUserBean user = users.get(position);
        ViewHolder holder;
        if (convertView == null || !(convertView.getTag() instanceof ViewHolder)) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_user_list_item, parent, false);
            holder.avatar = (CircleImageView)convertView.findViewById(R.id.avatar);
            holder.nickname = (TextView)convertView.findViewById(R.id.nickname);
            holder.item = (LinearLayout)convertView.findViewById(R.id.item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(user.getAvatar(), holder.avatar, parent.getContext());
        holder.nickname.setText(user.getNickname());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(parent.getContext(), ProfileOtherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userId", user.getUid());
                intent.putExtras(bundle);
                parent.getContext().startActivity(intent);
            }
        });
        return null;
    }

    private class ViewHolder{
        CircleImageView avatar;
        TextView nickname;
        LinearLayout item;
    }
}
