package cn.sportstory.android.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import cn.sportstory.android.R;

/**
 * Created by  Aaron.Zhang on 17-3-31.
 */

public class ImageLoader {

    private static ImageLoader instance = new ImageLoader();

    public static ImageLoader getInstance() {
        return instance;
    }

    private ImageLoader(){}

    private static final String IMAGE_TYPE_PNG = "png";
    private static final String IMAGE_TYPE_GIF = "gif";
    private static final String IMAGE_TYPE_JPG = "jpg";
    private static final String IMAGE_TYPE_JPEG = "jpeg";

    public void displayImage(Object url, ImageView imageView, Context context){
        context = context.getApplicationContext();
        String picUrl = null;
        if (url == null)
        {
            displayNormalImage(picUrl, imageView, context);
        }else {
            picUrl = (String) url;
            String type;
            if (picUrl.length() >= 4) {
                type = picUrl.substring(picUrl.length() - 4, picUrl.length());
                if (type.equals(IMAGE_TYPE_JPEG))
                    displayNormalImage(picUrl, imageView, context);
                else {
                    type = picUrl.substring(picUrl.length() - 3, picUrl.length());
                    if (type.equals(IMAGE_TYPE_JPG) || type.equals(IMAGE_TYPE_PNG)) {
                        displayNormalImage(picUrl, imageView, context);
                    } else if (type.equals(IMAGE_TYPE_GIF))
                        displayGifImage(picUrl, imageView, context);
                    else
                        displayNormalImage(picUrl, imageView, context);
                }
            }
        }
    }

    private void displayNormalImage(String picUrl, final ImageView imageView, Context context){
        Glide.with(context)
                .load(picUrl)
                .error(R.mipmap.ic_blank)
                .placeholder(R.mipmap.ic_blank)
                .centerCrop()
                .dontAnimate()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        imageView.setImageResource(R.mipmap.ic_blank);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    private void displayGifImage(String picUrl, final ImageView imageView, Context context){
        Glide.with(context)
                .load(picUrl)
                .asGif()
                .error(R.mipmap.ic_blank)
                .placeholder(R.mipmap.ic_blank)
                .centerCrop()
                .listener(new RequestListener<String, GifDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
                        imageView.setImageResource(R.mipmap.ic_blank);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
