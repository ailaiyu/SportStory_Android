package cn.sportstory.android.nearby.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Adapter;
import android.widget.ListView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/5.
 */

public class NearbySearchResultActivity extends BaseActivity {
    private ListView listView;
    private String searchArgs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_search_result);
        searchArgs = getIntent().getStringExtra("nickname");
        if (searchArgs != null) {
            listView = (ListView) findViewById(R.id.listview);
            SearchResultAdapter adapter = new SearchResultAdapter(null);
            listView.setAdapter(adapter);
        }
    }
}
