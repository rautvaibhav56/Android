package com.sunbeam.myproject2.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunbeam.myproject2.R;
import com.sunbeam.myproject2.fragment.LoginFragment;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);

                    SharedPreferences preferences =
                            PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);

                    if (preferences.getBoolean("login_status", false)) {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this, AuthActivity.class));
                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

