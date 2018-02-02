package com.app.xandone.ylayoutsample.anim;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

/**
 * author: xandone
 * created on: 2018/2/2 16:55
 */

public class TweenAnimActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_tween_rotate;

    @Override
    protected int setLayout() {
        return R.layout.act_tween_anim_layout;
    }

    @Override
    protected void init() {
        img_tween_rotate = (ImageView) findViewById(R.id.img_tween_rotate);

        img_tween_rotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_tween_rotate:
                loadAnim(img_tween_rotate, R.anim.tween_rotate);
                break;
        }
    }

    public void loadAnim(View view, int animRes) {
        Animation animation = AnimationUtils.loadAnimation(this, animRes);
        view.startAnimation(animation);
    }
}
