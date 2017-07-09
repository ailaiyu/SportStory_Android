package cn.sportstory.android.ui.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Sport;
import cn.sportstory.android.ui.base.BaseRvAdapter;


/**
 * Created by Tamas on 2016/4/23.
 */
public class SportListAdapter extends BaseRvAdapter {

    private static final String TAG=SportListAdapter.class.getName();
    private List<Sport> mSportList;



    public SportListAdapter(List<Sport> sportList) {
        mSportList=sportList;
    }

    @Override
    public SimpleItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView;

        itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sport, viewGroup, false);
        return new SimpleItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(BaseRvViewHolder vh, int position) {
        Sport item=mSportList.get(position);

        SimpleItemViewHolder viewHolder=(SimpleItemViewHolder)vh;

        viewHolder.tvSportName.setText(item.getName());
        viewHolder.ivSport.setImageResource(item.getImageRes());



    }

    @Override
    public int getItemCount() {
        return (this.mSportList!= null) ? this.mSportList.size() : 0;
    }
    //final static
    protected  class SimpleItemViewHolder extends BaseRvViewHolder {

        @BindView(R.id.tv_sport_name)
        TextView tvSportName;
        @BindView(R.id.iv_sport)
        ImageView ivSport;

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }




}