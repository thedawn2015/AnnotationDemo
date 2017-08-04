package com.app.simon.annotationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.app.simon.annotationdemo.model.AnTest;

public class MainActivity extends AppCompatActivity {
    /** TAG */
    public static final String TAG = MainActivity.class.getSimpleName();

    public static int id;
    private String name;

    private android.widget.Button btntoother;
    private AnTest anTest;

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
        id = 10;
        name = "Simon";

        anTest = new AnTest();
        anTest.setId(110);
        anTest.setName("大侠");
        anTest.setPhone(String.valueOf(1588888888));
    }

    private void printSS(String s) {
        Log.i(TAG, "printSS: " + s);
    }
}
