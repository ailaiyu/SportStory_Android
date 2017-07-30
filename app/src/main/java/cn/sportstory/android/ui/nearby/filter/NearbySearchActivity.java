package cn.sportstory.android.ui.nearby.filter;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sportstory.android.R;
import cn.sportstory.android.ui.base.BaseActivity;

/**
 * Created by Tamas on 2017/7/30.
 */

public class NearbySearchActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstancceState){
        super.onCreate(savedInstancceState);
        setContentView(R.layout.activity_nearby_search);
        ButterKnife.bind(this);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
