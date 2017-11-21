package com.app.xandone.ylayoutsample.coor;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Button;

import com.app.xandone.ylayoutsample.R;

/**
 * author: xandone
 * created on: 2017/11/21 16:32
 */

public class CoordinatorLayoutAct extends AppCompatActivity {
    private Button hello_btn;
    private Button depend_btn;

    int curreny_x;
    int curreny_y;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.act_coor_layout);
        hello_btn = (Button) findViewById(R.id.hello_btn);
        depend_btn = (Button) findViewById(R.id.depend_btn);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        curreny_x = (int) event.getX();
        curreny_y = (int) event.getY();
        depend_btn.scrollTo(curreny_x, curreny_y);
        return true;
    }
}
