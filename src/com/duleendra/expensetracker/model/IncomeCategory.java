package com.duleendra.expensetracker.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="income_category")
public class IncomeCategory {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "incomeCategory" ,targetEntity = Income.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Collection<Income> incomeList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Income> getIncomeList() {
		return incomeList;
	}
	public void setIncomeList(Collection<Income> incomeList) {
		this.incomeList = incomeList;
	}
	
	
	
	
}
