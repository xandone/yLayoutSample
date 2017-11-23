package com.app.xandone.ylayoutsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.app.xandone.ylayoutsample.cons.ConstraintLayoutAct;
import com.app.xandone.ylayoutsample.coor.CoordinatorLayoutAct;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_0;
    private Button btn_1;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        toolBar = (Toolbar) findViewById(R.id.toolBar);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);

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
        }
        startActivity(intent);
    }
}
