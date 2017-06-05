package cn.sportstory.android.nearby.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/5.
 */

public class NearbySearchActivity extends BaseActivity {
    private SearchView searchView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_search);
        searchView = (SearchView) findViewById(R.id.search);
    }
}
