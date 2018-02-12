package com.app.xandone.ylayoutsample.anim;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

/**
 * author: xandone
 * created on: 2018/2/2 16:27
 */

public class AnimActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;

    @Override
    protected int setLayout() {
        return R.layout.act_anim_layout;
    }

    @Override
    protected void init() {
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(AnimActivity.this, TweenAnimActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(AnimActivity.this, PropertyAnimActivity.class));
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                startActivity(new Intent(AnimActivity.this, PathAnimActivity.class));
                break;
        }
    }
}
