package com.example.expensetracker;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// This is the adapter for the RecyclerView that will handle the arraylist of expenses
public class ExpensesListAdapter extends RecyclerView.Adapter<ExpensesListAdapter.ViewHolder> {
    private ArrayList<Expense> expensesListInAdapter;

    public ExpensesListAdapter(ArrayList<Expense> expenseArraylist) {
        expensesListInAdapter = expenseArraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Expense currentExpense = expensesListInAdapter.get(position);
        holder.text1.setText(currentExpense.getExpense());
        holder.text2.setText(currentExpense.displayAmount());
    }

    @Override
    public int getItemCount() {
        return expensesListInAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1;
        private TextView text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = (TextView) itemView.findViewById(R.id.list_expense);
            text2 = (TextView) itemView.findViewById(R.id.list_amount);
        }

        public TextView getText1() { return text1; }
        public TextView getText2() { return text2; }
    }
}