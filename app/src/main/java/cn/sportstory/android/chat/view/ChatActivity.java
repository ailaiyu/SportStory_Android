package cn.sportstory.android.chat.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/5/5.
 *
 * -----2017/05/05更新(Aaron.Zhang)------------
 * 聊天界面activity，包含一个title和一个fragment
 * 依据聊天类型会有不同的界面展示， 目前这个版本只有单聊消息
 * 目前想到有三种场景进入这个activity：
 *      1：从会话列表进入
 *      2：从消息通知栏进入
 *      3：从对方个人主页里面进入
 */

public class ChatActivity extends BaseActivity {
    private Toolbar toolbar;

    public static final String CHAT_TYPE_P2P = "0";      //单聊
    public static final String CHAT_TYPE_GROUP = "1";    //群聊

    public static final String BUNDLE_CHAT_TARGET_ID = "CHAT_BUNDLE_TARGET_ID"; //intent中聊天对象id key
    public static final String BUNDLE_CHAT_TYPE = "CHAT_BUNDLE_TYPE";           //intent中聊天类型key

    private ChatFragment chatFragment;
    private String targetId;
    private String chat_type;
    private TextView mTvUserName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Bundle bundle = intent.getExtras();
        if (bundle == null)
            return;
        targetId = bundle.getString(BUNDLE_CHAT_TARGET_ID, null);
        chat_type = bundle.getString(BUNDLE_CHAT_TYPE);
        if (TextUtils.isEmpty(chat_type) || TextUtils.isEmpty(targetId))
            return;
        initView();

        chatFragment = new ChatFragment();
        chatFragment.setArguments(bundle);
    }

    /**
     * 根据聊天id和聊天类型 -初始化界面
     */
    private void initView(){
        mTvUserName = (TextView) findViewById(R.id.tv_chat_title_nickname);
        mTvUserName.setText("ID是" + targetId + "的用户");
    }
}
