package com.app.xandone.ylayoutsample.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.app.xandone.ylayoutsample.R;
import com.app.xandone.ylayoutsample.utils.PathParserUtils;
import com.app.xandone.ylayoutsample.utils.StoreHousePath;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/**
 * author: xandone
 * created on: 2018/2/7 9:52
 */

public class PathView extends View {
    private Paint mPaint;
    private Path path1, path2;
    private ValueAnimator mValueAnimator;
    protected static final long DURATION = 2000;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        path1 = PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("XIAOJY", 1.1f, 16));
        path2 = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        canvas.drawPath(path1, mPaint);

        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        canvas.drawPath(path2, mPaint);
    }

    public void startPath(Path path1, Path path2, long duration) {
        if (path1 == null || path2 == null) {
            return;
        }
        PathMeasure pathMeasure = new PathMeasure();
        path2.reset();
        path2.lineTo(0, 0);
        pathMeasure.setPath(path1, false);
        int count = 0;
        while (pathMeasure.getLength() != 0) {
            pathMeasure.nextContour();
            count++;
        }
        pathMeasure.setPath(path1, false);
        int one_duration = (int) (duration / count);
        loadAnim(path1, path2, one_duration, pathMeasure);
    }

    public void loadAnim(final Path path1, final Path path2, long duration, final PathMeasure pathMeasure) {
        stopAnim();

        mValueAnimator = ValueAnimator.ofFloat(0, 1);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.setDuration(duration);
        mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                //获取一个段落
                pathMeasure.getSegment(0, pathMeasure.getLength() * value, path2, true);
                invalidate();
            }
        });
        mValueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("yandone", "repeat..");
                pathMeasure.getSegment(0, pathMeasure.getLength(), path2, true);
                pathMeasure.nextContour();
                if (pathMeasure.getLength() == 0) {
                    animation.end();
                }
            }
        });
        mValueAnimator.start();
    }

    public void startAnim() {
        startPath(path1, path2, DURATION);
    }

    public void stopAnim() {
        if (mValueAnimator != null && mValueAnimator.isRunning()) {
            mValueAnimator.end();
        }
    }

}
