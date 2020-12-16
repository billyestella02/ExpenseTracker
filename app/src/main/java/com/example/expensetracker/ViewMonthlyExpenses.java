package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ViewMonthlyExpenses extends AppCompatActivity {
    ArrayList<Expense> expensesList;
    private RecyclerView recyclerView;
    private ExpensesListAdapter expensesListAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_expenses);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e) {}

        // get arraylist from viewmonthlyexpenses.java
        Intent intent = getIntent();
        String jsonExpensesList = intent.getStringExtra("key");

        // convert string to Expenses ArrayList
        Gson gson = new Gson();
        Type expensesListType = new TypeToken<ArrayList<Expense>>(){}.getType();
        expensesList = gson.fromJson(jsonExpensesList, expensesListType);

        recyclerView = (RecyclerView) findViewById(R.id.listOfExpenses);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        expensesListAdapter = new ExpensesListAdapter(expensesList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(expensesListAdapter);
    }
}
