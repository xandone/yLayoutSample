package com.app.xandone.ylayoutsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

    protected void startAct(Class cls) {
        startActivity(new Intent(this, cls));
    }

}
