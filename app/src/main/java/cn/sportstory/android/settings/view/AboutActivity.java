package cn.sportstory.android.settings.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/8.
 */

public class AboutActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_about);
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.help).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/6/8 goto help
                gotoHelp();
            }
        });

        findViewById(R.id.feedback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutActivity.this, PostFeedbackActivity.class));
            }
        });

        findViewById(R.id.protocol).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoProtocol();
            }
        });
    }

    private void gotoHelp(){

    }

    private void gotoProtocol(){
        Intent intent = new Intent();
        intent.putExtra("url", "file:///android_asset/protocol.html");
        intent.setClass(this, ProtocolActivity.class);
        startActivity(intent);
    }
}
