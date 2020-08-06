package com.app.xandone.ylayoutsample.coor;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * author: xandone
 * created on: 2017/11/22 11:26
 */

public class BtnBehavior extends CoordinatorLayout.Behavior<TextView> {
    private int width;

    public BtnBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        int top = (int) dependency.getX();
        int left = (int) dependency.getY();
        int x = width - left - child.getWidth();
        int y = top;
        CoordinatorLayout.MarginLayoutParams params = (CoordinatorLayout.MarginLayoutParams) child.getLayoutParams();
        params.leftMargin = x;
        params.topMargin = y;
        child.setLayoutParams(params);
        return true;
    }
}
