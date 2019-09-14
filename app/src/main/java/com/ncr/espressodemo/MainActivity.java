package com.ncr.espressodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ncr.espressodemo.Utilities.NumberCounter;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    //Views
    TextView mNumberTv;
    Button mIncrementBtn;
    Button mDecrementBtn;
    Button mReadyBtn;

    //Model
    NumberCounter mNumberCounter;
    static String NUMBER_EXTRA = "number_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mNumberTv = findViewById(R.id.number_tv);
        mIncrementBtn = findViewById(R.id.increment_btn);
        mIncrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberCounter.duplicate();
                mNumberTv.setText(Integer.toString(mNumberCounter.getNumber()));
            }
        });
        mDecrementBtn = findViewById(R.id.decrement_btn);
        mDecrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumberCounter.decrement();
                mNumberTv.setText(Integer.toString(mNumberCounter.getNumber()));
            }
        });
        mReadyBtn = findViewById(R.id.ready_btn);
        mReadyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scrollIntent = new Intent(mContext, ScrollActivity.class);
                scrollIntent.putExtra(NUMBER_EXTRA, mNumberCounter.getNumber());
                mContext.startActivity(scrollIntent);
            }
        });

        mNumberCounter = new NumberCounter();
    }

}
