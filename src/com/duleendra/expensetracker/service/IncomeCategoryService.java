package com.duleendra.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duleendra.expensetracker.dao.IncomeCategoryDao;
import com.duleendra.expensetracker.model.IncomeCategory;

@Service
public class IncomeCategoryService {

	@Autowired 
	IncomeCategoryDao incomeDao;
	
	public void saveIncomeCategory(IncomeCategory incomeCategory) {
		incomeDao.saveIncomeCategory(incomeCategory);
	}
	
	public List<IncomeCategory> getAllIncomeCategories() {
		return incomeDao.getAllIncomeCategories();
	}
	
	public IncomeCategory findIncomeCategory(int id) {
		return incomeDao.findIncomeCategory(id);
	}
	
	public int deleteIncomeCategory(int id) {
		return incomeDao.deleteIncomeCategory(id);
	}
}
