package com.app.xandone.ylayoutsample.coor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.xandone.ylayoutsample.R;

/**
 * author: xandone
 * created on: 2017/11/21 16:32
 */

public class CoordinatorLayoutAct extends AppCompatActivity {
    private TextView hello_btn;
    private Button depend_btn;

    int curreny_x;
    int curreny_y;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_coor_layout);
        hello_btn = (TextView) findViewById(R.id.hello_btn);
        depend_btn = (Button) findViewById(R.id.depend_btn);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                curreny_x = (int) (event.getX() - 0.5 * depend_btn.getWidth());
                curreny_y = (int) (event.getY() - 1.5 * depend_btn.getHeight());
                break;
            case MotionEvent.ACTION_MOVE:
                curreny_x = (int) (event.getX() - 0.5 * depend_btn.getWidth());
                curreny_y = (int) (event.getY() - 1.5 * depend_btn.getHeight());
                break;
            case MotionEvent.ACTION_UP:
                curreny_x = (int) (event.getX() - 0.5 * depend_btn.getWidth());
                curreny_y = (int) (event.getY() - 1.5 * depend_btn.getHeight());
                break;
        }
        depend_btn.setX(curreny_x);
        depend_btn.setY(curreny_y);
        return false;
    }
}
