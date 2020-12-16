package com.example.expensetracker;

import java.text.DateFormat;
import java.util.Calendar;

// Basic Expense class
public class Expense {
    private String expense;
    private float amount;
    private String dateAdded;

    // constructor
    public Expense() {
        expense = "";
        amount = 0;
    }

    public void addExpense(String expense, float amount) {
        this.expense = expense;
        this.amount = amount;
        Calendar calendar = Calendar.getInstance();
        dateAdded = DateFormat.getDateInstance().format(calendar.getTime());
    }

    public String getExpense() {
        return expense;
    }

    public float getAmount() {
        return amount;
    }

    public String displayAmount() {
        String amountInPesos = "₱" + String.valueOf(amount) + "0";
        return amountInPesos;
    }
}
