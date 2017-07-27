package cn.sportstory.android.ui.login.perfectinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sportstory.android.R;
import cn.sportstory.android.entity.Sport;
import cn.sportstory.android.ui.base.BaseRvAdapter;


/**
 * Created by Tamas on 2016/4/23.
 */
public class ScoreListAdapter extends BaseRvAdapter {

    private static final String TAG=ScoreListAdapter.class.getName();
    private List<Sport> mSportList;



    public ScoreListAdapter(List<Sport> sportList) {
        mSportList=sportList;
    }

    @Override
    public SimpleItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView;

        itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_set_sport_score, viewGroup, false);
        return new SimpleItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(BaseRvViewHolder vh, final int position) {
        Sport item=mSportList.get(position);

        SimpleItemViewHolder viewHolder=(SimpleItemViewHolder)vh;

        viewHolder.ivChoosedSport.setImageResource(item.getImageRes());
        viewHolder.ivChoosedSport.setSelected(true);
        viewHolder.ratingSportScore.setRating(item.getScore());
        viewHolder.ratingSportScore.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Sport item=mSportList.get(position);
                item.setScore(rating);
            }
        });



    }

    @Override
    public int getItemCount() {
        return (this.mSportList!= null) ? this.mSportList.size() : 0;
    }
    //final static
    protected  class SimpleItemViewHolder extends BaseRvViewHolder {

        @BindView(R.id.iv_choosed_sport)
        ImageView ivChoosedSport;
        @BindView(R.id.rating_sport_score)
        RatingBar ratingSportScore;

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }




}