package com.app.xandone.ylayoutsample.utils.loader;

import android.content.Context;
import android.view.View;

import java.io.Serializable;

/**
 * author: xandone
 * created on: 2018/2/12 15:11
 */

public interface ImageLoaderInterface<T extends View> extends Serializable {

    public void displayImage(Context context, Object path, T imageView);

    T createImage(Context context);
}
