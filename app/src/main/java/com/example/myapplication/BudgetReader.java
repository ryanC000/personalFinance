package com.example.myapplication;
public class BudgetReader {
    private int budgetTotal;
    private String budgetName;

    public BudgetReader(int budgetTotal, String budgetName) {
        this.budgetTotal = budgetTotal;
        this.budgetName = budgetName;
    }

    public BudgetReader() {
    }

    public int getBudgetTotal() {
        return budgetTotal;
    }

    public String getBudgetName() {
        return budgetName;
    }
}
