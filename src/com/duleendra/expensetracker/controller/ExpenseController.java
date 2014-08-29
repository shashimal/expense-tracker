package com.duleendra.expensetracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.duleendra.expensetracker.model.Category;
import com.duleendra.expensetracker.model.Expense;
import com.duleendra.expensetracker.service.CategoryService;
import com.duleendra.expensetracker.service.ExpenseService;

@Controller
public class ExpenseController {

	private static final Logger logger = Logger.getLogger(ExpenseController.class);
	
	@Autowired
	CategoryService categoryService;
	@Autowired 
	ExpenseService expenseService;
	
	@RequestMapping("/viewExpenses.action")
	public ModelAndView viewExpenses(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		return new ModelAndView("expense_list", "expenses", expenseService.getAllExpenses());
	}

	@RequestMapping(value ="/newExpense.action",method = RequestMethod.GET)
	public String newExpense(Model model) {
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("expenseObject", new Expense());
		model.addAttribute("categories", categories);
		return "expense_add";
	}
	
	@RequestMapping(value = "/saveExpense.action",method = RequestMethod.POST)
	private ModelAndView saveExpense(@ModelAttribute("expenseObject") Expense expense ,Model model) {
		expenseService.saveExpense(expense);
		
		System.out.println(expense.getExpenseDate());
		
		return new ModelAndView("redirect:/viewExpenses.action", "model", "");
	}
	
	@RequestMapping(value="/deleteExpense/{id}", method = RequestMethod.GET)
	public  ModelAndView deleteCategory(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		expenseService.deleteExpense(id);
		return new ModelAndView("redirect:/viewExpenses.action");
		
	}
	
	@RequestMapping(value="/editExpense/{id}", method = RequestMethod.GET)
	public String editExpense(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		model.addAttribute("categories",categoryService.getAllCategories());
		model.addAttribute("expenseObject",expenseService.findExpense(id));
		return "expense_edit";
	}

	

}
