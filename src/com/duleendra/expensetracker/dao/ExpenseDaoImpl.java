package com.duleendra.expensetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.duleendra.expensetracker.model.Category;
import com.duleendra.expensetracker.model.Expense;

@Repository
public class ExpenseDaoImpl implements ExpenseDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void saveExpense(Expense expense) {
		if(expense.getId() != 0) {
			em.merge(expense);
		}else{
			em.persist(expense);
		}
	}

	@Transactional
	public List<Expense> getAllExpenses() {
		List<Expense> result = em.createQuery("SELECT e FROM Expense e ORDER BY e.expenseDate DESC", Expense.class).getResultList();
		return result;
	}

	@Transactional
	public int deleteExpense(int id) {
		Query query = em.createQuery("DELETE FROM Expense e WHERE e.id = :p");
		int deletedCount = query.setParameter("p", id).executeUpdate();
		return deletedCount;
	}

	@Transactional
	public Expense findExpense(int id) {
		return em.find(Expense.class, id);
	}

}
