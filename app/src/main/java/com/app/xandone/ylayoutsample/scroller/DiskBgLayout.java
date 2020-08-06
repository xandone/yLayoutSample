package com.app.xandone.ylayoutsample.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * author: Admin
 * created on: 2020/8/6 16:20
 * description:
 */
public class DiskBgLayout extends ViewGroup {
    private DiskView diskView;
    private DiskPointer diskPointer;

    public DiskBgLayout(Context context) {
        this(context, null);
    }

    public DiskBgLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiskBgLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        final int width = getMeasuredWidth();
        final int height = getMeasuredHeight();
        final int childLeft = getPaddingLeft();
        final int childTop = getPaddingTop();
        //由于这里child只有一个所以将整个长宽都设置给child
        View child = this.getChildAt(0);
        child.layout(childLeft, childTop, width - getPaddingRight(), height - getPaddingBottom());

        View child2 = this.getChildAt(1);
        child2.layout(width / 2 - 100,
                height / 2 - 100,
                width / 2 + 100,
                height / 2 + 100
        );
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init(Context context) {
        diskView = new DiskView(context);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        diskView.setLayoutParams(layoutParams);

        diskPointer = new DiskPointer(context);
        LayoutParams layoutParams2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        diskPointer.setLayoutParams(layoutParams2);

        addView(diskView);
        addView(diskPointer);

        //设置ViewGroup可画
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
