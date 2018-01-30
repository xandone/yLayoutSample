package com.app.xandone.ylayoutsample.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * author: xandone
 * created on: 2018/1/29 9:55
 */

public class ObservableScrollView extends ScrollView {
    private OnScrollListener onScrollListener;

    private int mTouchSlop;
    private int downY;

    public ObservableScrollView(Context context) {
        this(context, null);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollListener != null) {
            onScrollListener.onScroll(t);
        }
    }

    @Override
    protected int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    public interface OnScrollListener {
        void onScroll(int scrollY);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }
        }
        return super.onInterceptTouchEvent(e);
    }


}
