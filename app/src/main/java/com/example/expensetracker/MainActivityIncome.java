package com.example.expensetracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityIncome extends AppCompatActivity {
    private Button buttonNextExpense;
    private Button buttonSubmitIncome;
    private EditText incomeInput;
    Income income = new Income();

    public static final String SP_INCOME = "sharedPrefs";
    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_income);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e) {}

        incomeInput = (EditText) findViewById(R.id.incomeInput);
        buttonNextExpense = (Button) findViewById(R.id.buttonNextExpense);
        buttonSubmitIncome = (Button) findViewById(R.id.submitIncome);

        buttonSubmitIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {saveIncomeInput();}

        });

        buttonNextExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivityExpense();
            }
        });
    }

    public void saveIncomeInput() {
        income.addIncome(Float.parseFloat(incomeInput.getText().toString()));
        Gson gson = new Gson();
        String json = gson.toJson(income);

        SharedPreferences sharedPreferences = getSharedPreferences(SP_INCOME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, json);
        editor.commit();

        incomeInput.setText("");
    }

    public void openMainActivityExpense() {
        Intent intent = new Intent(this, MainActivityExpense.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}