package com.gg.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextFullName, editTextUserName;
    Button buttonLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupPreferences();

        editTextFullName = findViewById(R.id.editTextFullName);
        editTextUserName = findViewById(R.id.editTextUserName);
        buttonLogin = findViewById(R.id.buttonLogin);

        View.OnClickListener clickAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = editTextFullName.getText().toString();
                String userName = editTextUserName.getText().toString();

                if (!TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(userName)) {
                    Intent intent = new Intent(LoginActivity.this, NotesActivity.class);
                    intent.putExtra(AppConstant.FULL_NAME, fullName);
                    intent.putExtra(AppConstant.USER_NAME, userName);
                    startActivity(intent);
                    saveLoginStatus();
                }else{
                    Toast.makeText(LoginActivity.this, "FullName and UserName can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        };

        buttonLogin.setOnClickListener(clickAction);
    }

    private void saveLoginStatus() {
        editor = sharedPreferences.edit();
        editor.putBoolean(PrefConstant.IS_LOGGED_IN, true);
        editor.apply();
    }

    private void setupPreferences(){
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
    }
}
