package com.duleendra.expensetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.duleendra.expensetracker.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager em;

	//@Transactional
	public void saveCategory(Category category) {
		if(category.getId() != 0) {
			em.merge(category);
		}else{
			em.persist(category);
		}
		
	}

	//@Transactional
	public List<Category> getAllCategories() {
		 List<Category> result = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
		 return result;
	}

	//@Transactional
	public Category findCategory(int id) {
		return em.find(Category.class, id);
	}

	//@Transactional
	public int deleteCategory(int id) {
		Query query = em.createQuery("DELETE FROM Category c WHERE c.id = :p");
		int deletedCount = query.setParameter("p", id).executeUpdate();
		return deletedCount;
		
	}

}
