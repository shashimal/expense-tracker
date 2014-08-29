package com.duleendra.expensetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.duleendra.expensetracker.model.IncomeCategory;

@Repository
public class IncomeCategoryImpl implements IncomeCategoryDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void saveIncomeCategory(IncomeCategory income) {
		if(income.getId() != 0) {
			em.merge(income);
		}else{
			em.persist(income);
		}
		
	}

	@Transactional
	public List<IncomeCategory> getAllIncomeCategories() {
		List<IncomeCategory> result = em.createQuery("SELECT i FROM IncomeCategory i", IncomeCategory.class).getResultList();
		 return result;
	}

	@Transactional
	public IncomeCategory findIncomeCategory(int id) {
		return em.find(IncomeCategory.class, id);
	}

	@Transactional
	public int deleteIncomeCategory(int id) {
		Query query = em.createQuery("DELETE FROM IncomeCategory i WHERE i.id = :p");
		int deletedCount = query.setParameter("p", id).executeUpdate();
		return deletedCount;
	}

}
