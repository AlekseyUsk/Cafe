package com.bignerdranch.android.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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
    private String userName;
    private String drinkType;

    public static final String USER_NAME = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_starbucks);

        init();
        getMessageIntentSetupUserName();
        theUsersChoiceOfTheDrink();
        onUserMadeOrder();
    }

    private void onUserMadeOrder() {
        btnMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> additives = new ArrayList<>();
                if (checkboxSugar.isChecked()) {
                    additives.add(checkboxSugar.getText().toString());
                }
                if (checkboxMilk.isChecked()) {
                    additives.add(checkboxMilk.getText().toString());
                }
                if (radioButtonTea.isChecked() & checkboxLemon.isChecked()) {
                    additives.add(checkboxLemon.getText().toString());
                }
                additives.toString();

                drinkType = "";
                if (radioButtonTea.isChecked()) {
                    drinkType = spinnerTea.getSelectedItem().toString();
                } else if (radioButtonCoffee.isChecked()) {
                    drinkType = spinnerCoffee.getSelectedItem().toString();
                }
                Intent intent = OrderScreenActivity.newIntent(MenuStarbucksActivity.this,
                        userName,
                        drink,
                        drinkType,
                        additives.toString());
                startActivity(intent);
            }
        });
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
        checkboxLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);
    }

    private void onChoseUserCoffee() {
        drink = getString(R.string.radioBtnCoffee);
        String drinkUser = getString(R.string.textViewAddComponents);
        String resultDrinkUser = String.format(drinkUser, drink);
        textViewAddComponents.setText(resultDrinkUser);
        checkboxLemon.setVisibility(View.INVISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
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

        userName = getIntent().getStringExtra(USER_NAME);
        String greetings = getString(R.string.greetings);
        String result = String.format(greetings, userName);
        textViewGreetings.setText(result);
    }
}