package com.example.wenhan.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private TextView testTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate start!");
        setContentView(R.layout.activity_main);
        testTv = (TextView) findViewById(R.id.testTv);
        measureView(testTv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume start!");
        measureView(testTv);
    }

    private int[] measureView(final View view) {
        final int[] returnData = new int[2];
        view.post(new Runnable() {
            @Override
            public void run() {
                returnData[0] = view.getWidth();
                returnData[1] = view.getHeight();
                Log.i(TAG, "Width: " + returnData[0] + ", height: " + returnData[1]);
            }
        });
        return returnData;
    }

}
