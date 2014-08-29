package com.duleendra.expensetracker.dao;

import java.util.List;

import com.duleendra.expensetracker.model.Expense;

public interface ExpenseDao {

	public List<Expense> getAllExpenses();
	public void saveExpense(Expense expense);
	public int deleteExpense(int id);
	public Expense findExpense(int id);
}
