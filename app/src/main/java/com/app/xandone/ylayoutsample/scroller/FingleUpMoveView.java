package com.app.xandone.ylayoutsample.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * author: Admin
 * created on: 2020/8/6 11:06
 * description:
 */
public class FingleUpMoveView extends View {

    Scroller scroller;

    public FingleUpMoveView(Context context) {
        this(context, null);
    }

    public FingleUpMoveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FingleUpMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    Paint mPaint;

    void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        scroller = new Scroller(getContext());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, 100, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!scroller.isFinished()) {
                    scroller.abortAnimation();
                }
                scroller.startScroll(-getScrollX(), -getScrollY(), (int) event.getX() + getScrollX(), (int) event.getY() + getScrollY(), 500);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
        }
        return true;
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(-scroller.getCurrX(), -scroller.getCurrY());
            postInvalidate();
        }
    }
}
