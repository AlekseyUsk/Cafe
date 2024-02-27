package com.bignerdranch.android.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuStarbucksActivity extends AppCompatActivity {

    private TextView textViewGreetings;
    private TextView textViewAddComponents;

    private RadioGroup radioGroup;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;

    private CheckBox checkboxSugar;
    private CheckBox checkboxMilk;
    private CheckBox checkboxLemon;

    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private Button btnMakeOrder;

    private String drink;


    public static final String USER_NAME = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_starbucks);

        init();
        getMessageIntentSetupUserName();
        theUsersChoiceOfTheDrink();

    }

    private void theUsersChoiceOfTheDrink() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == radioButtonTea.getId()) {
                    onChoseUserTea();
                } else if (id == radioButtonCoffee.getId()) {
                    onChoseUserCoffee();
                } else {
                    Exception e;
                }
            }
        });
    }

    private void onChoseUserTea() {
        drink = getString(R.string.radioBtnTea);
        String drinkUser = getString(R.string.textViewAddComponents);
        String resultDrinkUser = String.format(drinkUser, drink);
        textViewAddComponents.setText(resultDrinkUser);
    }

    private void onChoseUserCoffee() {
        drink = getString(R.string.radioBtnCoffee);
        String drinkUser = getString(R.string.textViewAddComponents);
        String resultDrinkUser = String.format(drinkUser, drink);
        textViewAddComponents.setText(resultDrinkUser);
    }

    public static Intent newIntent(Context context, String userName) {
        Intent intent = new Intent(context, MenuStarbucksActivity.class);
        intent.putExtra(USER_NAME, userName);
        return intent;
    }

    private void init() {

        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewAddComponents = findViewById(R.id.textViewAddComponents);

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);

        checkboxSugar = findViewById(R.id.checkboxSugar);
        checkboxMilk = findViewById(R.id.checkboxMilk);
        checkboxLemon = findViewById(R.id.checkboxLemon);

        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);

        btnMakeOrder = findViewById(R.id.btnMakeOrder);

    }

    private void getMessageIntentSetupUserName() {

        String userName = getIntent().getStringExtra(USER_NAME);
        String greetings = getString(R.string.greetings);
        String result = String.format(greetings, userName);
        textViewGreetings.setText(result);
    }
}