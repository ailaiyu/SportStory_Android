package cn.sportstory.android.timeline.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;
import cn.sportstory.android.account.contract.GetOSTokenContract;
import cn.sportstory.android.account.presenter.GetOsTokenPresenter;
import cn.sportstory.android.common.bean.OSTokenBean;
import cn.sportstory.android.common.bean.TimelineBean;
import cn.sportstory.android.common.tools.ListHelper;
import cn.sportstory.android.timeline.contract.TimelinePostContract;
import cn.sportstory.android.timeline.presenter.TimelinePostPresenter;

/**
 * Created by aaron on 2017/6/10.
 */

public class PostTimelineActivity extends BaseActivity{

    private TextView post;
    private GridView pics;
    private TextInputEditText content;
    private TimelinePostView postView;
    private PostPicsAdapter adapter;
    private TimelinePostContract.Presenter postPresenter;
    private GetOsTokenPresenter getOsTokenPresenter;
    private GetOsTokenView getOsTokenView;
    private List<String> picPaths;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_timeline);
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initView();
        initData();
    }

    private void initView(){
        picPaths=new ArrayList<>();
        post = (TextView)findViewById(R.id.post);
        post.setEnabled(false);
        pics = (GridView)findViewById(R.id.imgs);
        adapter = new PostPicsAdapter(picPaths);
        pics.setAdapter(adapter);
        content = (TextInputEditText)findViewById(R.id.content);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = content.getText() == null ? null : content.getText().toString();
                if (!TextUtils.isEmpty(str) || !ListHelper.isEmpty(picPaths)){
                        TimelineBean bean = new TimelineBean();
                    bean.setContent(str);
                    bean.setPicCount(ListHelper.CountOfList(picPaths));
                    postPresenter.setupTask(bean);
                    postPresenter.doTask();
                }else {

                }
            }
        });
    }

    private void initData(){
        getOsTokenView = new GetOsTokenView();
        postView = new TimelinePostView();
        postPresenter = new TimelinePostPresenter(postView);
        getOsTokenPresenter = new GetOsTokenPresenter(getOsTokenView);
    }

    private class TimelinePostView extends TimelinePostContract.View{
        @Override
        public Context getViewContext() {
            return getBaseContext();
        }

        @Override
        public void postFailed(TimelineBean bean) {
            Toast.makeText(getViewContext(), "发送失败，请重试", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void postSuccess(TimelineBean bean) {
            Toast.makeText(getViewContext(), "发送成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private class GetOsTokenView extends GetOSTokenContract.View{
        @Override
        public Context getViewContext() {
            return getBaseContext();
        }

        @Override
        public void getTokenSuccess(OSTokenBean bean) {

        }

        @Override
        public void getTokenFailed(OSTokenBean bean) {

        }
    }

}
