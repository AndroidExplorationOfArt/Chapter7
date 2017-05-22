package com.kjn.chapter7;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ValueActivity extends AppCompatActivity {

    private Button mButton;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);
        mButton = (Button) findViewById(R.id.my_button);
        mButton1 = (Button) findViewById(R.id.textBtn);
        mButton2 = (Button) findViewById(R.id.textBtn2);
        mButton3 = (Button) findViewById(R.id.textBtn3);
        mButton4 = (Button) findViewById(R.id.textBtn4);
        mButton5 = (Button) findViewById(R.id.textBtn5);
        mButton6 = (Button) findViewById(R.id.textBtn6);

    }

    public void toIntent(View view) {
        if (view == mButton1) {
            ObjectAnimator.ofFloat(mButton, "translationX", 200).start();
        } else if (view == mButton2) {
            //设置背景颜色变化范围
            ObjectAnimator colorAnim = ObjectAnimator.ofInt(mButton, "backgroundColor", 0xFFFF8080, 0xFF8080FF);
            colorAnim.setDuration(2000);
            colorAnim.setEvaluator(new ArgbEvaluator());
            //INFINITE 表示无限次
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);
            //REVERSE 表示反转效果
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim.start();
        } else if (view == mButton3) {
            AnimatorSet set = new AnimatorSet();
            set.playTogether(
                    ObjectAnimator.ofFloat(mButton, "rotationX", 0, 360),
                    ObjectAnimator.ofFloat(mButton, "rotationY", 0, 360),
                    ObjectAnimator.ofFloat(mButton, "rotation", 0, -180),
                    ObjectAnimator.ofFloat(mButton, "translationX", 0, 90),
                    ObjectAnimator.ofFloat(mButton, "translationY", 0, 90),
                    ObjectAnimator.ofFloat(mButton, "scaleX", 1, 1.5f),
                    ObjectAnimator.ofFloat(mButton, "scaleY", 0, 2.5f),
                    ObjectAnimator.ofFloat(mButton, "alpha", 1, 0.25f, 1)
            );
            set.setDuration(5000).start();
        } else if (view == mButton4) {
            AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(ValueActivity.this, R.animator.my_animator);
            set.setTarget(mButton);
            set.start();
        }else if (view == mButton5) {
            ViewWrapper viewWrapper = new ViewWrapper(mButton);
            ObjectAnimator.ofInt(viewWrapper, "width", 50000).setDuration(2000).start();
        }else if (view == mButton6) {
            performAnimate2(mButton, mButton.getWidth(), 5000);
        }
    }

    private void performAnimate() {
        ViewWrapper viewWrapper = new ViewWrapper(mButton);
        ObjectAnimator.ofInt(viewWrapper, "width", 5000).setDuration(2000).start();
    }

    public static class ViewWrapper {

        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }

    private void performAnimate2(final View target, final int start, final int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            private IntEvaluator mEvaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();

                float fraction = animation.getAnimatedFraction();

                target.getLayoutParams().width = mEvaluator.evaluate(fraction, start, end);
                target.requestLayout();
            }
        });

        valueAnimator.setDuration(5000).start();
    }
}

