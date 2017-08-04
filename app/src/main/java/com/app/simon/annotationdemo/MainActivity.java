package com.app.simon.annotationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /** TAG */
    public static final String TAG = MainActivity.class.getSimpleName();

    private android.widget.Button btntoother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        assignViews();
    }

    private void assignViews() {
        this.btntoother = (Button) findViewById(R.id.btn_to_other);
        this.btntoother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherActivity.launch(MainActivity.this);
            }
        });
    }

    private void initData() {
    }
}
