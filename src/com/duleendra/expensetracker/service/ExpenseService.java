package com.duleendra.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duleendra.expensetracker.dao.ExpenseDao;
import com.duleendra.expensetracker.model.Expense;

@Service
public class ExpenseService {

	@Autowired
	ExpenseDao expenseDao;
	
	public void saveExpense(Expense expense){
		expenseDao.saveExpense(expense);
	}
	
	public List<Expense> getAllExpenses() {
		return expenseDao.getAllExpenses();
	}
	
	public int deleteExpense(int id) {
		return expenseDao.deleteExpense(id);
	}
	
	public Expense findExpense(int id) {
		return expenseDao.findExpense(id);
	}
}
