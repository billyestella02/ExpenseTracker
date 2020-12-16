package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivityExpense extends AppCompatActivity {
    private EditText expenseInput;
    private EditText amountInput;
    private Button addExpenseButton;
    private Button viewExpensesListButton;
    ArrayList<Expense> expensesList = new ArrayList<Expense>(20);
    String json;


    public static final String SP_EXPENSE = "sharedPrefs";
    public static final String TEXT_EXP = "textExp";
    public static final String INTENT_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_expenses);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e) {}

        expenseInput = (EditText) findViewById(R.id.expenseInput);
        amountInput = (EditText) findViewById(R.id.amountInput);
        addExpenseButton = (Button) findViewById(R.id.addExpense);
        viewExpensesListButton = (Button) findViewById(R.id.viewExpenses);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpense();
            }
        });

        viewExpensesListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewExpensesListActivity();
            }
        });
    }

    public void addExpense() {
        String e = expenseInput.getText().toString();
        float a = Float.parseFloat(amountInput.getText().toString());
        Expense expense = new Expense();
        expense.addExpense(e, a);
        expensesList.add(expense);

        Gson gson = new Gson();
        json = gson.toJson(expensesList);

        SharedPreferences sharedPreferences = getSharedPreferences(SP_EXPENSE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT_EXP, json);
        editor.commit();

        expenseInput.setText("");
        amountInput.setText("");
    }

    public void viewExpensesListActivity() {
        Log.d("viewExpenses: ", "THIS IS MY LAST WAR");
        Intent intent = new Intent(this, ViewMonthlyExpenses.class);
        intent.putExtra(INTENT_KEY, json);
        startActivity(intent);
    }
}
