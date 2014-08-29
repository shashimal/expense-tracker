package com.duleendra.expensetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.duleendra.expensetracker.model.Income;


@Repository
public class IncomeDaoImpl implements IncomeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveIncome(Income income) {
		if(income.getId() != 0) {
			em.merge(income);
		}else{
			em.persist(income);
		}
		
	}

	@Override
	public List<Income> getAllIncome() {
		List<Income> result = em.createQuery("SELECT i FROM Income i", Income.class).getResultList();
		 return result;
	}

	@Override
	public Income findIncome(int id) {
		return em.find(Income.class, id);
	}

	@Override
	public int deleteIncome(int id) {
		Query query = em.createQuery("DELETE FROM Income i WHERE i.id = :p");
		int deletedCount = query.setParameter("p", id).executeUpdate();
		return deletedCount;
	}

}
