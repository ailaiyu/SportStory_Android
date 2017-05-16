package cn.sportstory.android.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import cn.sportstory.android.tools.ImageLoader;

/**
 * Created by aaron on 2017/5/16.
 */

public class MySquareImageView extends ImageView {


    public MySquareImageView(Context context) {
        super(context);
    }


    public MySquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }


}
