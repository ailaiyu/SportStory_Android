package cn.sportstory.android.account.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.common.bean.UserLocationBean;
import cn.sportstory.android.common.service.LocationService;

/**
 * Created by aaron on 2017/5/13.
 */

public class ChooseCityActivity extends BaseActivity {
    private Toolbar toolbar;
    private ListView listView;
    private LinearLayout mLlGps;
    private String gpsCity;
    private TextView mTvGpsCity;
    private LocationServiceReceiver receiver;

    private boolean locateSuccess = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        mLlGps = (LinearLayout)findViewById(R.id.ll_gps);
        mTvGpsCity = (TextView)findViewById(R.id.city);
        listView = (ListView)findViewById(R.id.city_list);
        receiver = new LocationServiceReceiver();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final CityListAdapter adapter = new CityListAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String city = (String) adapter.getItem(position);
                if (!city.contains(" "))
                    chooseCity(city);
            }
        });

        mLlGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (locateSuccess){
                    chooseCity(gpsCity);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, LocationService.class);
        stopService(intent);
        startService(intent);
        IntentFilter filter = new IntentFilter();
        filter.addAction(LocationService.ACTION_LOCATION_SUCCESS);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            unregisterReceiver(receiver);
        }catch (IllegalArgumentException e){

        }
    }

    private void chooseCity(String city){
        Intent intent = new Intent();
        intent.putExtra("city", city);
        setResult(RESULT_OK, intent);
        finish();
    }

    private class LocationServiceReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            locateSuccess = true;
            UserLocationBean bean = intent.getExtras().getParcelable("location");
            if (bean != null && bean.getCity() != null) {
                gpsCity = bean.getCity();
                mTvGpsCity.setText(gpsCity);
            }
        }
    }
}
