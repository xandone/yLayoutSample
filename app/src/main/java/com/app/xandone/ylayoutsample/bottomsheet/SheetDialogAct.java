package com.app.xandone.ylayoutsample.bottomsheet;

import android.view.View;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/**
 * author: Admin
 * created on: 2018/9/6 13:47
 * description:
 */
public class SheetDialogAct extends BaseActivity {
    private BottomSheetDialog mDialog;
    private SheetFrag mDialogFragment;


    @Override
    protected int setLayout() {
        return R.layout.act_sheet_dialog;
    }

    @Override
    protected void init() {
        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        findViewById(R.id.dialog_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogFrag();
            }
        });

    }


    public void showDialog() {
        mDialog = new BottomSheetDialog(this);
        mDialog.setContentView(R.layout.v_sheet_dialog);
        mDialog.show();
    }

    public void hideDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.hide();
        }
    }


    public void showDialogFrag() {
        mDialogFragment = new SheetFrag();
        mDialogFragment.show(getSupportFragmentManager(), "demoBottom");
    }

    public void hideDialogFrag() {
        if (mDialogFragment != null) {
            mDialogFragment.dismiss();
        }
    }
}
