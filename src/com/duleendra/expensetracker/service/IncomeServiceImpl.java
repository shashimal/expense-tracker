package com.duleendra.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duleendra.expensetracker.dao.IncomeDao;
import com.duleendra.expensetracker.model.Income;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Autowired 
	IncomeDao incomeDao;
	
	@Transactional
	public void saveIncome(Income income) {
		incomeDao.saveIncome(income);
	}
	
	@Transactional
	public List<Income> getAllIncome() {
		return incomeDao.getAllIncome();
	}
	
	@Transactional
	public Income findIncome(int id) {
		return incomeDao.findIncome(id);
	}
	
	@Transactional
	public int deleteIncome(int id) {
		return incomeDao.deleteIncome(id);
	}
}
