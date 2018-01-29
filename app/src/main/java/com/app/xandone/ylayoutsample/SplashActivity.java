package com.app.xandone.ylayoutsample;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * author: xandone
 * created on: 2017/12/19 9:59
 */

public class SplashActivity extends AppCompatActivity {
    private ImageView splashBgIv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash_layout);

        splashBgIv = (ImageView) findViewById(R.id.splash_bg_iv);

        splashBgIv.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(2000)
                .setStartDelay(100)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        jumpToMain();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }).start();
    }

    public void jumpToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
