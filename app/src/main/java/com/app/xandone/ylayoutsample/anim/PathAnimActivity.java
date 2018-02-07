package com.app.xandone.ylayoutsample.anim;

import android.view.View;
import android.widget.Button;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

/**
 * author: xandone
 * created on: 2018/2/7 9:36
 */

public class PathAnimActivity extends BaseActivity implements View.OnClickListener {
    PathView pathView;
    Button btn_0;

    @Override
    protected int setLayout() {
        return R.layout.act_path_anim_layout;
    }

    @Override
    protected void init() {
        pathView = (PathView) findViewById(R.id.pathView);
        btn_0 = (Button) findViewById(R.id.btn_0);

        pathView.setOnClickListener(this);
        btn_0.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pathView:
                break;
            case R.id.btn_0:
                pathView.startAnim();
                break;
        }
    }
}
