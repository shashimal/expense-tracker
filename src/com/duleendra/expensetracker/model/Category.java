package com.duleendra.expensetracker.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category" ,targetEntity = Expense.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Collection expenses;

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

}
