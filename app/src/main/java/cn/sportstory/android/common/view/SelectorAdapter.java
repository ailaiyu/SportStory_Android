package cn.sportstory.android.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/19.
 */

public class SelectorAdapter extends BaseAdapter {
    private String [] contents;
    @Override
    public int getCount() {
        return contents.length;
    }

    @Override
    public Object getItem(int position) {
        return contents[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SelectorViewHolder holder;
        if (convertView == null){
            holder = new SelectorViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_item, parent, false);
            holder.bottomLine = (TextView)convertView.findViewById(R.id.divider_bottom);
            holder.topLine = (TextView)convertView.findViewById(R.id.divider_top);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }else {
            holder = (SelectorViewHolder)convertView.getTag();
        }
        holder.content.setText(contents[position]);
        return convertView;
    }

    private class SelectorViewHolder{
        private TextView topLine;
        private TextView bottomLine;
        private TextView content;

    }
}
