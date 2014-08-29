package com.duleendra.expensetracker.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.duleendra.expensetracker.model.Category;
import com.duleendra.expensetracker.model.Income;
import com.duleendra.expensetracker.model.IncomeCategory;
import com.duleendra.expensetracker.service.IncomeCategoryService;
import com.duleendra.expensetracker.service.IncomeService;
import com.duleendra.expensetracker.service.IncomeServiceImpl;

@Controller
public class IncomeController {

	@Autowired
	IncomeService incomeService;
	@Autowired
	IncomeCategoryService incomeCategoryService;
	
	@RequestMapping("/viewAllIncome")
	public ModelAndView viewAllIncome() {
		return new ModelAndView("income_list","allIncome",incomeService.getAllIncome());
	}
	
	@RequestMapping(value = "/newIncome.action", method = RequestMethod.GET)
	public String newIncome(Model model) {
		model.addAttribute("incomeObject", new Income());
		model.addAttribute("incomeCategories",incomeCategoryService.getAllIncomeCategories());
		return "income_add";
	}
	
	@RequestMapping(value = "/saveIncome.action", method = RequestMethod.POST)
    public  ModelAndView saveIncome(@ModelAttribute("incomeObject") Income income, 
      Model model) {
		incomeService.saveIncome(income);
		return new ModelAndView("redirect:/viewAllIncome.action");
	}
	
	@RequestMapping(value="/viewInome/{id}", method = RequestMethod.GET)
	public String viewInomce(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		Income income = incomeService.findIncome(id);
		model.addAttribute("incomeCategories",incomeCategoryService.getAllIncomeCategories());
		model.addAttribute("incomeObject", income);
		return "income_edit";	
	}
	
	@RequestMapping(value="/deleteIncome/{id}", method = RequestMethod.GET)
	public  ModelAndView deleteIncome(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		incomeService.deleteIncome(id);
		return new ModelAndView("redirect:/viewAllIncome.action");
		
	}
}
