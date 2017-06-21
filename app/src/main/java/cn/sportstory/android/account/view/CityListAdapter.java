package cn.sportstory.android.account.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cn.sportstory.android.R;
import cn.sportstory.android.constants.StringConstants;


/**
 * Created by aaron on 2017/6/18.
 */

public class CityListAdapter extends BaseAdapter {
   ArrayList<String> cities;

    public CityListAdapter() {
        reset();
    }

    @Override
    public int getCount() {
        return cities == null ? 0 : cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        String cityName = cities.get(position);
        boolean isNotCity = cityName.contains(" ");
        ViewHolder holder;
        if (isNotCity){
            if (convertView == null || !(convertView.getTag() instanceof ProvinceViewHolder)){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.province_item, parent, false);
                holder = new ProvinceViewHolder();
                holder.city = (TextView)convertView.findViewById(R.id.city_name);
                holder.item = (LinearLayout)convertView.findViewById(R.id.item);
            }else {
                holder = (ProvinceViewHolder)convertView.getTag();
            }
        }else {
            if (convertView == null || !(convertView.getTag() instanceof CityViewHolder)) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
                holder = new CityViewHolder();
                holder.city = (TextView)convertView.findViewById(R.id.city_name);
                holder.item = (LinearLayout)convertView.findViewById(R.id.item);
            }else {
                holder = (CityViewHolder)convertView.getTag();
            }
        }
        holder.city.setText(cities.get(position));
        return convertView;
    }

    private class ViewHolder{
        TextView city;
        LinearLayout item;
    }

    private class CityViewHolder extends ViewHolder{
    }

    private class ProvinceViewHolder extends ViewHolder{
    }

    public void setSearch(String str){
        str = str.trim();
        if (TextUtils.isEmpty(str))
            return;
        if (cities == null)
            cities = new ArrayList<>();
        cities.clear();
        for (int i = 0; i < StringConstants.cities.length; i ++)
            if (StringConstants.cities[i].contains(str) && !StringConstants.cities[i].contains(" "))
                cities.add(StringConstants.cities[i]);
        notifyDataSetChanged();
    }
    public void reset(){
        cities = new ArrayList<>();
        cities.clear();
        for (String str : StringConstants.cities)
            cities.add(str);
    }
}
