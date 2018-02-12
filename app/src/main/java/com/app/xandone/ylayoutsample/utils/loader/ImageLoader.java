package com.app.xandone.ylayoutsample.utils.loader;

import android.content.Context;
import android.widget.ImageView;

/**
 * author: xandone
 * created on: 2018/2/12 15:23
 */

public class ImageLoader implements ImageLoaderInterface<ImageView> {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

    }

    @Override
    public ImageView createImage(Context context) {
        ImageView imageView = new ImageView(context);
        return imageView;
    }
}
