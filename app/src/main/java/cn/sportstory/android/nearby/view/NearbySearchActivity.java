package cn.sportstory.android.nearby.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/5.
 */

public class NearbySearchActivity extends BaseActivity {
    private SearchView searchView;
    private Toolbar toolbar;
    private Button search;
    private LinearLayout mLlSearch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_search);
        searchView = (SearchView) findViewById(R.id.search);
        search = (Button)findViewById(R.id.btn_search);
        mLlSearch = (LinearLayout)findViewById(R.id.search);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        initEvent();
    }

    private void initEvent(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mLlSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
