package com.sunbeam.myproject2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunbeam.myproject2.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
