package com.app.xandone.ylayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author: xandone
 * created on: 2018/1/29 10:03
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        init();
    }

    protected abstract int setLayout();

    protected abstract void init();

}
