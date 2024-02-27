package com.bignerdranch.android.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderScreenActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewTypeDrink;
    private TextView addition;

    private static final String USER_NAME_EXTRA = "userName";
    private static final String DRINK_EXTRA = "drink";
    private static final String TYPE_DRINK_EXTRA = "typeDrink";
    private static final String ADDITIVES_EXTRA = "additives";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        init();
        getMessageIntentSetupUserName();
    }

    private void init() {
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewTypeDrink = findViewById(R.id.textViewTypeDrink);
        addition = findViewById(R.id.addition);
    }

    public static Intent newIntent(Context context,
                                   String userName,
                                   String drink,
                                   String typeDrink,
                                   String additives) {
        Intent intent = new Intent(context, OrderScreenActivity.class);
        intent.putExtra(USER_NAME_EXTRA, userName);
        intent.putExtra(DRINK_EXTRA, drink);
        intent.putExtra(TYPE_DRINK_EXTRA, typeDrink);
        intent.putExtra(ADDITIVES_EXTRA, additives);
        return intent;
    }

    private void getMessageIntentSetupUserName() {

        Intent intent = getIntent();
        textViewName.setText(intent.getStringExtra(USER_NAME_EXTRA));
        textViewDrink.setText(intent.getStringExtra(DRINK_EXTRA));
        textViewTypeDrink.setText(intent.getStringExtra(TYPE_DRINK_EXTRA));
        addition.setText(intent.getStringExtra(ADDITIVES_EXTRA));
    }
}