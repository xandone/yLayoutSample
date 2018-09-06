package com.app.xandone.ylayoutsample.bottomsheet;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.LinearLayout;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

/**
 * author: Admin
 * created on: 2018/9/6 10:15
 * description:
 */
public class SheetAct extends BaseActivity implements View.OnClickListener {
    private LinearLayout dialog;
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected int setLayout() {
        return R.layout.act_sheet;
    }

    @Override
    protected void init() {
        dialog = (LinearLayout) findViewById(R.id.dialog);
        //把这个底部菜单和一个BottomSheetBehavior关联起来
        mBottomSheetBehavior = BottomSheetBehavior.from(dialog);

        findViewById(R.id.state_expanded).setOnClickListener(this);
        findViewById(R.id.state_collapsed).setOnClickListener(this);
        findViewById(R.id.state_hidden).setOnClickListener(this);

//        当处于展开状态时，偏移量为1
//        当处于收起状态时，偏移量为0
//        当处于隐藏状态时，偏移量为-1
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {

            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }

    public void expandBottomSheet() {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void hideBottomSheet() {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    public void collapseBottomSheet() {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.state_expanded:
                expandBottomSheet();
                break;
            case R.id.state_collapsed:
                collapseBottomSheet();
                break;
            case R.id.state_hidden:
                hideBottomSheet();
                break;
        }
    }


}
