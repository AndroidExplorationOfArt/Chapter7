package com.kjn.chapter7;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Mian";
    private Button mButton;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.textBtn);
        mButton2 = (Button) findViewById(R.id.textBtn2);
        mButton3 = (Button) findViewById(R.id.textBtn3);
        mButton4 = (Button) findViewById(R.id.textBtn4);
    }

    public void toIntent(View view) {
        if (view == mButton) {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.my_anim,R.anim.my_anim);
        } else if (view == mButton2){
            Intent intent = new Intent(MainActivity.this, Rotate3dActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.my_anim,R.anim.my_anim);
        } else if (view == mButton3) {
            Intent intent = new Intent(MainActivity.this, ValueActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.my_anim,R.anim.my_anim);
        }  else if (view == mButton4) {
            Intent intent = new Intent(MainActivity.this, FrameActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.my_anim,R.anim.my_anim);
        }
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.my_anim,R.anim.my_anim);
    }

}
