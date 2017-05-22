package com.kjn.chapter7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = new String[]{
            "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"
    };
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mListView = (ListView) findViewById(R.id.list_view);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_item);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        mListView.setLayoutAnimation(controller);
    }

    public void toListView(View view) {
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_text, data));

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.my_anim,R.anim.my_anim);
    }
}
