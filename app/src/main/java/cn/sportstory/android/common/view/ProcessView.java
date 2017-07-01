package cn.sportstory.android.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/7/1.
 */

public class ProcessView extends LinearLayout {

    public ProcessView(Context context, String string) {
        super(context);
        init(string);
    }

    private void init(String str){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.process_dialog, null);
        TextView content = (TextView)view.findViewById(R.id.process_content);
        content.setText(str);
    }
}
