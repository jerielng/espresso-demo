package com.ncr.espressodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollActivity extends AppCompatActivity {

    enum ColorConfig {
        RED, BLUE;
    }

    //Views
    LinearLayout mScrollLayout;
    ColorConfig mColorConfig;

    private int mainScreenNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        Intent intent = getIntent();
        mainScreenNumber = intent.getIntExtra(MainActivity.NUMBER_EXTRA, 0);
        processNumber();

        mScrollLayout = findViewById(R.id.scrollLayout);
        populateScrollView();
    }

    public void processNumber() {
        if (mainScreenNumber < 0) {
            mColorConfig = ColorConfig.RED;
            mainScreenNumber *= -1;
        } else {
            mColorConfig = ColorConfig.BLUE;
        }
    }

    public void populateScrollView() {
        for (int i = 1; i <= mainScreenNumber; i++) {
            TextView newTv = new TextView(this);
            newTv.setText(Integer.toString(i));
            newTv.setHeight(500);
            newTv.setTextColor(getResources().getColor(R.color.white));
            newTv.setGravity(Gravity.CENTER);
            newTv.setTextSize(36);

            LinearLayout.LayoutParams marginParams =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            marginParams.setMargins(10, 10, 10, 10);
            newTv.setLayoutParams(marginParams);

            if (mColorConfig == ColorConfig.BLUE) {
                newTv.setBackgroundColor(getResources().getColor(R.color.blue));
            } else {
                newTv.setBackgroundColor(getResources().getColor(R.color.red));
            }
            if (i == mainScreenNumber) {
                newTv.setId(R.id.last_view);
            }
            mScrollLayout.addView(newTv);
        }
    }
}
