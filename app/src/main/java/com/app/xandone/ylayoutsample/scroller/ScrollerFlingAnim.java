package com.app.xandone.ylayoutsample.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/**
 * author: xandone
 * created on: 2017/10/26 10:24
 */

public class ScrollerFlingAnim extends View {
    private VelocityTracker velocityTracker;
    private int mMaximumVelocity, mMinimumVelocity;
    private Context mContext;
    private OverScroller overScroller;
    private Interpolator interpolator;

    private int mMinPositionX;
    private int mMaxPositionX;

    private int r_x, r_y;
    private int radius = 48;

    private Paint mPaint;

    public ScrollerFlingAnim(Context context) {
        this(context, null);
    }

    public ScrollerFlingAnim(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollerFlingAnim(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    public void init() {
        velocityTracker = VelocityTracker.obtain();
        mMaximumVelocity = ViewConfiguration.get(mContext).getScaledMaximumFlingVelocity();
        mMinimumVelocity = ViewConfiguration.get(mContext).getScaledMinimumFlingVelocity();
        interpolator = new BounceInterpolator();
        overScroller = new OverScroller(mContext, interpolator);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(r_x, r_y, radius, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        velocityTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!overScroller.isFinished()) {
                    overScroller.abortAnimation();
                }
                velocityTracker.clear();
                velocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                int velocity_x = (int) velocityTracker.getXVelocity();
                if (Math.abs(velocity_x) > mMinimumVelocity) {
                    fling();
                }
                velocityTracker.clear();
                break;
            case MotionEvent.ACTION_CANCEL:
                if (!overScroller.isFinished()) {
                    overScroller.abortAnimation();
                }
                break;
        }

        return true;
    }

    public void fling() {
        overScroller.startScroll(0, 0, mMinPositionX, 0, 1600);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (overScroller.computeScrollOffset()) {
            scrollTo(overScroller.getCurrX(), overScroller.getCurrY());
            postInvalidate();
        } else {
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    scrollTo(0, 0);
                }
            }, 300);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMinPositionX = -w / 2 + radius;
        mMaxPositionX = w / 2 - radius;
        this.r_x = w / 2;
        this.r_y = h / 2;
    }
}
