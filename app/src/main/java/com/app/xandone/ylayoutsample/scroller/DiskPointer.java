package com.app.xandone.ylayoutsample.scroller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author: Admin
 * created on: 2020/8/6 17:39
 * description:
 */
public class DiskPointer extends View {
    private Paint paint;
    private Bitmap bitmapBuff;
    private Canvas bitmapCanvas;

    private int w, h;
    private int radius = 100;


    public DiskPointer(Context context) {
        this(context, null);
    }

    public DiskPointer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiskPointer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setDither(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

    }

    private void drawbg() {
        bitmapCanvas.drawCircle(w / 2, h / 2, radius, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmapBuff, 0, 0, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
        bitmapBuff = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmapCanvas = new Canvas(bitmapBuff);

        drawbg();
    }
}
