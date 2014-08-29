package com.duleendra.expensetracker.dao;

import java.util.List;

import com.duleendra.expensetracker.model.IncomeCategory;

public interface IncomeCategoryDao {

	public void saveIncomeCategory(IncomeCategory incomeCategory);
	public List<IncomeCategory> getAllIncomeCategories();
	public IncomeCategory findIncomeCategory(int id);
	public int deleteIncomeCategory(int id);
}
