package com.duleendra.expensetracker.dao;

import java.util.List;

import com.duleendra.expensetracker.model.Income;

public interface IncomeDao {

	public void saveIncome(Income income);
	public List<Income> getAllIncome();
	public Income findIncome(int id);
	public int deleteIncome(int id);
}
