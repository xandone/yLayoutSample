package com.app.xandone.ylayoutsample.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

/**
 * author: xandone
 * created on: 2018/2/6 11:42
 */

public class PropertyAnimActivity extends BaseActivity implements View.OnClickListener {
    private TextView property_1;
    private TextView property_1_num;
    private TextView property_2;

    private int w, h;
    private int property_2_x, property_2_y;

    @Override
    protected int setLayout() {
        return R.layout.act_property_anim_layout;
    }

    @Override
    protected void init() {
        property_1 = (TextView) findViewById(R.id.property_1);
        property_1_num = (TextView) findViewById(R.id.property_1_num);
        property_2 = (TextView) findViewById(R.id.property_2);

        property_1.setOnClickListener(this);
        property_2.setOnClickListener(this);

        //new Handler().post时候，发现有几率property_2.getX()的值为0
        property_1.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams params = property_1.getLayoutParams();
                w = params.width;
                h = params.height;

                property_2_x = (int) property_2.getX();
                property_2_y = (int) property_2.getY();
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.property_1:
                showAnim();
                break;
            case R.id.property_2:
                drawPathAnim(getPath());
                break;
        }
    }

    public void showAnim() {
        final ViewGroup.LayoutParams params = property_1.getLayoutParams();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                int dX = w + (int) (400 * value);
                params.width = dX;
                property_1.setLayoutParams(params);
                property_1_num.setText(String.valueOf((int) (400 * value)));
            }
        });
        valueAnimator.start();
    }

    public Path getPath() {
        Path path = new Path();
        path.moveTo(property_2_x, property_2_y);
        path.rLineTo(400, 0);
        path.rLineTo(0, 600);
        return path;
    }

    public void drawPathAnim(Path path) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(property_2, property_2.X, property_2.Y, path);
        objectAnimator.setDuration(2000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                valueAnimator.getAnimatedValue();
            }
        });
        objectAnimator.start();
    }
}
