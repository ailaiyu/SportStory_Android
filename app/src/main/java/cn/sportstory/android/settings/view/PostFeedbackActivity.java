package cn.sportstory.android.settings.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.sportstory.android.BaseActivity;
import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/15.
 */

public class PostFeedbackActivity extends BaseActivity {

    private EditText content;
    private Button confirm;

    private boolean isPosted = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initView();
    }

    private void initView(){
        confirm = (Button)findViewById(R.id.post);
        content = (EditText)findViewById(R.id.et_feedback_content);
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = content.getText() == null ? null : content.getText().toString();
                if (TextUtils.isEmpty(str)) {
                    Toast.makeText(PostFeedbackActivity.this, getString(R.string.tip_input_content), Toast.LENGTH_SHORT).show();
                }else {
                    // TODO: 2017/6/17 提交
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!isPosted && content.getText()!= null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.tip))
                    .setMessage(getString(R.string.has_not_commit))
                    .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    })
                    .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            finish();
                        }
                    });
            builder.show();
        }
    }
}
