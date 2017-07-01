package cn.sportstory.android.timeline.view;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.List;

import cn.sportstory.android.R;
import cn.sportstory.android.common.tools.ListHelper;

/**
 * Created by aaron on 2017/7/1.
 */

public class PostPicsAdapter extends BaseAdapter {
    private List<String> paths;
    private static final int VIEW_TYPE_ADD = 1;
    private static final int VIEW_TYPE_IMAGE = 2;
    private static final int MAX_IMAGE_COUNT = 9;

    public PostPicsAdapter(List<String> paths) {
        this.paths = paths;
        paths.add(null);
    }

    @Override
    public int getCount() {
        return ListHelper.CountOfList(paths);
    }

    @Override
    public Object getItem(int position) {
        return paths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (ListHelper.CountOfList(paths) < MAX_IMAGE_COUNT){
            if (position < MAX_IMAGE_COUNT - 1)
                return VIEW_TYPE_IMAGE;
            else {
                return VIEW_TYPE_ADD;
            }
        }else {
            if (position != MAX_IMAGE_COUNT - 1){
                return VIEW_TYPE_IMAGE;
            }else {
                if (paths.get(MAX_IMAGE_COUNT - 1) == null)
                    return VIEW_TYPE_ADD;
                else
                    return VIEW_TYPE_IMAGE;
            }
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PostPicsViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_pics_item, null);
            holder = new PostPicsViewHolder();
            holder.image = (ImageView)convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else {
            holder = (PostPicsViewHolder)convertView.getTag();
        }
        if (getItemViewType(position) == VIEW_TYPE_ADD)
        {
            holder.image.setImageResource(R.mipmap.upload_photo);
        }else {
            File cropFile = new File(paths.get(position));
            Uri uri = FileProvider.getUriForFile(parent.getContext(),
                    parent.getContext().getPackageName() + ".fileprovider", cropFile);
            holder.image.setImageURI(uri);
        }
        return convertView;
    }

    private class PostPicsViewHolder {
        public ImageView image;
    }
}
