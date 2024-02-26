package com.bignerdranch.android.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MenuStarbucksActivity extends AppCompatActivity {

    public static String USER_NAME = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_starbucks);
    }

    public static Intent newIntent(Context context, String userName) {
        Intent intent = new Intent(context, MenuStarbucksActivity.class);
        intent.putExtra(USER_NAME, userName);
        return intent;
    }
}