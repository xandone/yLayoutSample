package com.app.xandone.ylayoutsample.scroller;

import android.animation.ValueAnimator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

/**
 * author: Admin
 * created on: 2020/8/6 14:10
 * description:
 */
public class DiskViewActivity extends BaseActivity {
    DiskBgLayout diskView;

    @Override
    protected int setLayout() {
        return R.layout.act_diskview;
    }

    @Override
    protected void init() {
        diskView = findViewById(R.id.diskView);
    }


    private void startRotate() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
        valueAnimator.setDuration(500);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(Animation.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                diskView.setRotation(((float) valueAnimator.getAnimatedValue()) * 3.6F);
            }
        });
        valueAnimator.start();

    }
}
