package cn.sportstory.android.profile.view;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.sportstory.android.R;
import cn.sportstory.android.profile.bean.Album;

/**
 * Created by Raylan on 2017/6/19.
 */

public class AlbumAdapter extends BaseQuickAdapter<Album,BaseViewHolder> {

    public AlbumAdapter(int LayoutResId, List data){
        super(LayoutResId,data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Album item) {
        helper.setText(R.id.tv_album,item.getAlbumName());


    }
}
