package com.duleendra.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duleendra.expensetracker.dao.CategoryDao;
import com.duleendra.expensetracker.model.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Transactional
	public void saveCategory(Category category) {
		categoryDao.saveCategory(category);
	}
	
	@Transactional
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
	@Transactional
	public Category findCategory(int id) {
		return categoryDao.findCategory(id);
	}
	
	@Transactional
	public int deleteCategory(int id) {
		return categoryDao.deleteCategory(id);
	}
}
