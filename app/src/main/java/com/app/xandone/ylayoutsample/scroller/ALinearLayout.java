package com.app.xandone.ylayoutsample.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.app.xandone.ylayoutsample.R;

import androidx.annotation.Nullable;

/**
 * author: xandone
 * created on: 2018/1/26 10:58
 */

public class ALinearLayout extends LinearLayout {
    private Context mContext;

    public ALinearLayout(Context context) {
        this(context, null);
    }

    public ALinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ALinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    public void init() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        layoutInflater.inflate(R.layout.a_layout, this);
    }

}
