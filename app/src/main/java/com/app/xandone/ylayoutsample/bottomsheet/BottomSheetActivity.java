package com.app.xandone.ylayoutsample.bottomsheet;

import android.view.View;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

/**
 * author: Admin
 * created on: 2018/9/6 10:05
 * description:
 */
public class BottomSheetActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int setLayout() {
        return R.layout.act_bottom_sheet_layout;
    }

    @Override
    protected void init() {
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startAct(SheetAct.class);
                break;
            case R.id.btn_2:
                break;
            case R.id.btn_3:
                break;
        }
    }
}
