package com.duleendra.expensetracker.service;

import java.util.List;

import com.duleendra.expensetracker.model.Income;

public interface IncomeService {

	public void saveIncome(Income income);
	public List<Income> getAllIncome();
	public Income findIncome(int id);
	public int deleteIncome(int id);
}
