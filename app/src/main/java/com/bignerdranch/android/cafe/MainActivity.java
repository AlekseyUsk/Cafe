package com.bignerdranch.android.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextUserPassword;
    private Button buttonOk;
    private String userName;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClick();
    }

    private void init() {
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextUserPassword = findViewById(R.id.editTextPassword);
        buttonOk = findViewById(R.id.btn_ok);
    }

    private void onClick() {
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = editTextUserName.getText().toString().trim();
                userPassword = editTextUserPassword.getText().toString().trim();

                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error_empty, Toast.LENGTH_SHORT).show();
                } else {
                    launchNextScreen();
                }
            }
        });
    }

    private void launchNextScreen() {
        Intent intent = MenuStarbucksActivity.newIntent(MainActivity.this, userName);
        startActivity(intent);
    }
}