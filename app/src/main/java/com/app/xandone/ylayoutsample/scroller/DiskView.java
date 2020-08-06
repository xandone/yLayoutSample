package com.app.xandone.ylayoutsample.scroller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;


import androidx.annotation.Nullable;

/**
 * author: Admin
 * created on: 2020/8/6 11:19
 * description:
 */
public class DiskView extends View {
    private int mCircleW = 200;
    private int viewW, viewH;
    Bitmap bitmapBuff;
    Canvas bitmapCanvas;
    Paint bitmapPaint;
    Paint mPaint;

    private VelocityTracker mVelocityTracker;
    private int mMaximumVelocity, mMinimumVelocity;
    private Scroller mScroller;
    public static final int BLOCK_COUNT = 10;
    private int blockAngle;


    public DiskView(Context context) {
        this(context, null);
    }

    public DiskView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiskView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmapPaint.setColor(Color.RED);
        bitmapPaint.setStyle(Paint.Style.STROKE);
        bitmapPaint.setStrokeWidth(10);
        //防抖
        bitmapPaint.setDither(true);

        mVelocityTracker = VelocityTracker.obtain();
        mScroller = new Scroller(getContext());
        mScrollAvailabilityRatio = 0.3F;
        mMaximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        mMinimumVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();

        blockAngle = 360 / BLOCK_COUNT;
    }

    private void drawCircleBg() {
        bitmapCanvas.drawCircle(mCircleW / 2, mCircleW / 2, mCircleW / 2, bitmapPaint);
        RectF rectF = new RectF(10, 10, mCircleW - 10, mCircleW - 10);
        bitmapPaint.setStyle(Paint.Style.FILL);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                bitmapPaint.setColor(Color.GREEN);
            } else {
                bitmapPaint.setColor(Color.BLUE);
            }
//            直接修改旋转的起始角度并不好写字
//            bitmapCanvas.drawArc(rectF, 0 + blockAngle * i, blockAngle, true, bitmapPaint);

            bitmapCanvas.save();
            bitmapCanvas.rotate(blockAngle * i, bitmapBuff.getWidth() / 2, bitmapBuff.getHeight() / 2);
            bitmapCanvas.drawArc(rectF, 270 - blockAngle / 2, blockAngle, true, bitmapPaint);
            bitmapPaint.setColor(Color.WHITE);
            bitmapPaint.setTextSize(50);
            bitmapPaint.setTypeface(Typeface.DEFAULT_BOLD);
            bitmapPaint.setTextAlign(Paint.Align.CENTER);
            bitmapCanvas.drawText("手机", mCircleW / 2, mCircleW / 6, bitmapPaint);
            bitmapCanvas.restore();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmapBuff, (viewW - mCircleW) / 2, (viewH - mCircleW) / 2, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewW = w;
        viewH = h;
        mCircleW = w;
        bitmapBuff = Bitmap.createBitmap(mCircleW, mCircleW, Bitmap.Config.ARGB_8888);
        bitmapCanvas = new Canvas(bitmapBuff);
        mPivotX = w / 2;
        mPivotY = h / 2;

        drawCircleBg();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x, y;
        x = event.getX();
        y = event.getY();
        mVelocityTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                handleActionMove(x, y);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_OUTSIDE:
                mVelocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                int velocityX = (int) mVelocityTracker.getXVelocity();
                int velocityY = (int) mVelocityTracker.getYVelocity();
                if (Math.abs(velocityX) > mMinimumVelocity || Math.abs(velocityY) > mMinimumVelocity) {
                    mScroller.fling(0, 0, velocityX, velocityY,
                            Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                }
                invalidate();
                break;
            default:
                break;
        }
        mStartX = x;
        mStartY = y;

        return true;
    }

    private void handleActionMove(float x, float y) {
        float l, t, r, b;
        if (mStartX > x) {
            r = mStartX;
            l = x;
        } else {
            r = x;
            l = mStartX;
        }
        if (mStartY > y) {
            b = mStartY;
            t = y;
        } else {
            b = y;
            t = mStartY;
        }
        float pA1 = Math.abs(mStartX - mPivotX);
        float pA2 = Math.abs(mStartY - mPivotY);
        float pB1 = Math.abs(x - mPivotX);
        float pB2 = Math.abs(y - mPivotY);
        float hypotenuse = (float) Math.sqrt(Math.pow(r - l, 2) + Math.pow(b - t, 2));
        float lineA = (float) Math.sqrt(Math.pow(pA1, 2) + Math.pow(pA2, 2));
        float lineB = (float) Math.sqrt(Math.pow(pB1, 2) + Math.pow(pB2, 2));
        if (hypotenuse > 0 && lineA > 0 && lineB > 0) {
            float angle = fixAngle((float) Math.toDegrees(Math.acos((Math.pow(lineA, 2) + Math.pow(lineB, 2) - Math.pow(hypotenuse, 2)) / (2 * lineA * lineB))));
            if (!Float.isNaN(angle)) {
                float sClockAngle = isClockwise(x, y) ? angle : -angle;
                setRotation(getRotation() + sClockAngle);
            }
        }
    }

    private float fixAngle(float rotation) {
        float angle = 360F;
        if (rotation < 0) {
            rotation += angle;
        }
        if (rotation > angle) {
            rotation = rotation % angle;
        }
        return rotation;
    }

    private boolean isClockwise(float x, float y) {
        return (isShouldBeGetY = Math.abs(y - mStartY) > Math.abs(x - mStartX)) ?
                x < mPivotX != y > mStartY : y < mPivotY == x > mStartX;
    }

    private void computeInertialSliding() {
        if (mScroller.computeScrollOffset()) {
            float y = ((isShouldBeGetY ? mScroller.getCurrY() : mScroller.getCurrX()) * mScrollAvailabilityRatio);
            if (mLastScrollOffset != 0) {
                float angle = fixAngle(Math.abs(y - mLastScrollOffset));
                setRotation(getRotation() + angle);
            }
            mLastScrollOffset = y;
        } else if (mScroller.isFinished()) {
            mLastScrollOffset = 0;
        }
    }


    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            computeInertialSliding();
            postInvalidate();
        }
    }

    private float mStartX, mStartY;
    private float mPivotX, mPivotY;
    private boolean isShouldBeGetY;
    private float mScrollAvailabilityRatio;
    private float mLastScrollOffset;
}
