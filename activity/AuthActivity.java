package com.sunbeam.myproject2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunbeam.myproject2.R;
import com.sunbeam.myproject2.fragment.LoginFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);


        getSupportActionBar().hide();

        addLoginScreen();
    }

    private void addLoginScreen(){
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout,loginFragment)
                .commit();

    }
}