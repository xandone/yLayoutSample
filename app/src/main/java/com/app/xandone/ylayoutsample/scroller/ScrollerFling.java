package com.app.xandone.ylayoutsample.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

import androidx.annotation.Nullable;
import androidx.annotation.Px;

/**
 * author: xandone
 * created on: 2017/10/26 10:24
 */

public class ScrollerFling extends View {
    private VelocityTracker velocityTracker;
    private int mMaximumVelocity, mMinimumVelocity;
    private Context mContext;
    private OverScroller overScroller;

    private float mLast;

    private int mMinPositionX;
    private int mMaxPositionX;

    private int r_x, r_y;
    private int radius = 48;

    private Paint mPaint;

    public ScrollerFling(Context context) {
        this(context, null);
    }

    public ScrollerFling(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollerFling(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    public void init() {
        velocityTracker = VelocityTracker.obtain();
        mMaximumVelocity = ViewConfiguration.get(mContext).getScaledMaximumFlingVelocity();
        mMinimumVelocity = ViewConfiguration.get(mContext).getScaledMinimumFlingVelocity();
        overScroller = new OverScroller(mContext);

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
        float current_x = event.getX();
        velocityTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!overScroller.isFinished()) {
                    overScroller.abortAnimation();
                }
                velocityTracker.clear();
                velocityTracker.addMovement(event);
                mLast = current_x;
                break;
            case MotionEvent.ACTION_MOVE:
                float d = mLast - current_x;
                mLast = current_x;
                scrollBy((int) d, 0);
                break;
            case MotionEvent.ACTION_UP:
                velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                int velocity_x = (int) velocityTracker.getXVelocity();
                if (Math.abs(velocity_x) > mMinimumVelocity) {
                    fling(-velocity_x);
                }
                velocityTracker.clear();
                break;
            case MotionEvent.ACTION_CANCEL:
                if (!overScroller.isFinished()) {
                    overScroller.abortAnimation();
                }
                break;
            default:
                break;
        }

        return true;
    }

    public void fling(int vX) {
        overScroller.fling(getScrollX(), 0, vX, 0, mMinPositionX, mMaxPositionX, 0, 0);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (overScroller.computeScrollOffset()) {
            scrollTo(overScroller.getCurrX(), overScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {

        if (x < mMinPositionX) {
            x = mMinPositionX;
        }
        if (x > mMaxPositionX) {
            x = mMaxPositionX;
        }
        if (x != getScrollX()) {
            super.scrollTo(x, y);
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
