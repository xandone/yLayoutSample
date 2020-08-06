package com.app.xandone.ylayoutsample.coor;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

/**
 * author: xandone
 * created on: 2017/11/22 9:44
 */

public class DependBtn extends AppCompatButton {

    private int w, h;

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
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                setX(x - w / 2);
                setY(y - h / 2);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
    }
}
