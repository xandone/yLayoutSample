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
    private ImageView img_tween_alpha;
    private ImageView img_tween_translate;
    private ImageView img_tween_scale;
    private ImageView img_tween_set;

    @Override
    protected int setLayout() {
        return R.layout.act_tween_anim_layout;
    }

    @Override
    protected void init() {
        img_tween_rotate = (ImageView) findViewById(R.id.img_tween_rotate);
        img_tween_alpha = (ImageView) findViewById(R.id.img_tween_alpha);
        img_tween_translate = (ImageView) findViewById(R.id.img_tween_translate);
        img_tween_scale = (ImageView) findViewById(R.id.img_tween_scale);
        img_tween_set = (ImageView) findViewById(R.id.img_tween_set);

        img_tween_rotate.setOnClickListener(this);
        img_tween_alpha.setOnClickListener(this);
        img_tween_translate.setOnClickListener(this);
        img_tween_scale.setOnClickListener(this);
        img_tween_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_tween_rotate:
                loadAnim(img_tween_rotate, R.anim.tween_rotate);
                break;
            case R.id.img_tween_alpha:
                loadAnim(img_tween_alpha, R.anim.tween_alpha);
                break;
            case R.id.img_tween_translate:
                loadAnim(img_tween_translate, R.anim.tween_tanslate);
                break;
            case R.id.img_tween_scale:
                loadAnim(img_tween_scale, R.anim.tween_scale);
                break;
            case R.id.img_tween_set:
                loadAnim(img_tween_set, R.anim.tween_set);
                break;
        }
    }

    public void loadAnim(View view, int animRes) {
        Animation animation = AnimationUtils.loadAnimation(this, animRes);
        view.startAnimation(animation);
    }
}
