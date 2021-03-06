package com.app.xandone.ylayoutsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.xandone.ylayoutsample.anim.AnimActivity;
import com.app.xandone.ylayoutsample.bar.AppbarAct;
import com.app.xandone.ylayoutsample.bottomsheet.BottomSheetActivity;
import com.app.xandone.ylayoutsample.cons.ConstraintLayoutAct;
import com.app.xandone.ylayoutsample.coor.CoordinatorLayoutAct;
import com.app.xandone.ylayoutsample.scroller.ScrollerAct;
import com.app.xandone.ylayoutsample.observableView.ObservableActviity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        toolBar = (Toolbar) findViewById(R.id.toolBar);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);

        toolBar.setTitle("MainActivity");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_0:
                intent.setClass(MainActivity.this, ConstraintLayoutAct.class);
                break;
            case R.id.btn_1:
                intent.setClass(MainActivity.this, CoordinatorLayoutAct.class);
                break;
            case R.id.btn_2:
                intent.setClass(MainActivity.this, AppbarAct.class);
                break;
            case R.id.btn_3:
                intent.setClass(MainActivity.this, ScrollerAct.class);
                break;
            case R.id.btn_4:
                intent.setClass(MainActivity.this, ObservableActviity.class);
                break;
            case R.id.btn_5:
                intent.setClass(MainActivity.this, AnimActivity.class);
                break;
            case R.id.btn_6:
                intent.setClass(MainActivity.this, BottomSheetActivity.class);
                break;
            default:
        }
        startActivity(intent);
    }
}
