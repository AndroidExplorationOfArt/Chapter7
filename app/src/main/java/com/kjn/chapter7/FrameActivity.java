package com.kjn.chapter7;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
    }

    public void click(View view) {
        view.setBackgroundResource(R.drawable.my_list);
        AnimationDrawable background = (AnimationDrawable) view.getBackground();
        background.start();
    }
}
