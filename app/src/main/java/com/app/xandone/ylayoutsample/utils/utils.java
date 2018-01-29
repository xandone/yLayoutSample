package com.app.xandone.ylayoutsample.utils;

import android.content.Context;

/**
 * author: xandone
 * created on: 2018/1/26 10:37
 */

public class utils {
    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
