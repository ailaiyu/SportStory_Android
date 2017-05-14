package cn.sportstory.android.account.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.NumberPicker;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/13.
 */

public class PerfectInfoShapeActivity extends BaseActivity implements View.OnClickListener {

    private NumberPicker mNpWeight;
    private NumberPicker mNpHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_info_shape);
        mNpHeight = (NumberPicker)findViewById(R.id.np_choose_shape_height);
        mNpWeight = (NumberPicker)findViewById(R.id.np_choose_shape_weight);
        mNpHeight.setMaxValue(240);
        mNpHeight.setMinValue(150);
        mNpWeight.setMaxValue(150);
        mNpWeight.setMinValue(40);

        mNpWeight.setValue(60);
        mNpHeight.setValue(175);

    }

    @Override
    public void onClick(View v) {

    }

}
