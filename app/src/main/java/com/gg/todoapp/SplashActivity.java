package com.gg.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupPreferences();
        setContentView(R.layout.activity_splash);
        checkLoginStatus();
    }

    private void checkLoginStatus(){
        boolean isLoggedIn = sharedPreferences.getBoolean(PrefConstant.IS_LOGGED_IN, false);
        Log.d("CheckLogin", "SplashActivity "+isLoggedIn);
        if (isLoggedIn){
            Intent intent = new Intent(SplashActivity.this, NotesActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void setupPreferences(){
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
    }
}
