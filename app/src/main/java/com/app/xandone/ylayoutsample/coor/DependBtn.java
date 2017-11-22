package com.app.xandone.ylayoutsample.coor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * author: xandone
 * created on: 2017/11/22 9:44
 */

public class DependBtn extends Button {
    int curreny_x;
    int curreny_y;

    public DependBtn(Context context) {
        this(context, null);
    }

    public DependBtn(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DependBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
