package com.duleendra.expensetracker.dao;

import java.util.List;

import com.duleendra.expensetracker.model.Category;

public interface CategoryDao {

	public void saveCategory(Category category);
	public List<Category> getAllCategories();
	public Category findCategory(int id);
	public int deleteCategory(int id);
	
}
