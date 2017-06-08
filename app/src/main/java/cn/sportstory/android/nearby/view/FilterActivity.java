package cn.sportstory.android.nearby.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/6.
 */

public class FilterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView female;
    private ImageView male;
    private TextView age;
    private LinearLayout llAge;
    private TextView sport;
    private LinearLayout llSport;
    private TextView level;
    private LinearLayout llLevel;
    private Button search;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_filter);
        initView();
    }

    private void initView(){
        female = (ImageView)findViewById(R.id.img_female);
        male = (ImageView)findViewById(R.id.img_male);
        age = (TextView)findViewById(R.id.tv_age);
        sport = (TextView)findViewById(R.id.tv_sport);
        level = (TextView)findViewById(R.id.tv_level);
        search = (Button)findViewById(R.id.search);
        llAge = (LinearLayout)findViewById(R.id.ll_age);
        llLevel = (LinearLayout)findViewById(R.id.ll_level);
        llSport = (LinearLayout)findViewById(R.id.ll_sport);

        female.setOnClickListener(this);
        male.setOnClickListener(this);
        llAge.setOnClickListener(this);
        llSport.setOnClickListener(this);
        llLevel.setOnClickListener(this);
        search.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ll_sport:
                selectSport();
                break;
            case R.id.ll_level:
                selectLevel();
                break;
            case R.id.ll_age:
                selectAge();
                break;
            case R.id.search:
                search();
                break;
        }
    }

    private void selectSport(){

    }

    private void selectLevel(){

    }

    private void selectAge(){

    }

    private void search(){

    }
}
