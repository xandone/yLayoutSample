package com.app.xandone.ylayoutsample.bottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.xandone.ylayoutsample.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.Nullable;

/**
 * author: Admin
 * created on: 2018/9/6 14:02
 * description:
 */
public class SheetFrag extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.v_sheet_dialog, container, false);
    }
}
