package com.duleendra.expensetracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="income")
public class Income {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	private double amount;
	
	@Column(name = "income_category_id")
	private int incomeCategoryId;
	
	@Column(name="income_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date incomeDate;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="income_category_id",referencedColumnName="id",insertable=false,updatable=false)
	private IncomeCategory incomeCategory;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getIncomeCategoryId() {
		return incomeCategoryId;
	}
	public void setIncomeCategoryId(int incomeCategoryId) {
		this.incomeCategoryId = incomeCategoryId;
	}
	public IncomeCategory getIncomeCategory() {
		return incomeCategory;
	}
	public void setIncomeCategory(IncomeCategory incomeCategory) {
		this.incomeCategory = incomeCategory;
	}
	public Date getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}
	
	
	
	
}
