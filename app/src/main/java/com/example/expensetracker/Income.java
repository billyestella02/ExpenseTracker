package com.example.expensetracker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Income {
    private float income;
    private String dateAdded;

    public Income() {
        this.income = 0;
    }

    public void addIncome(float income) {
        this.income = income;
        Calendar calendar = Calendar.getInstance();
        dateAdded = DateFormat.getDateInstance().format(calendar.getTime());
    }

    public float getIncome() {
        return income;
    }
    public String getDateAdded() { return dateAdded; }

}
