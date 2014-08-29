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
import com.duleendra.expensetracker.model.IncomeCategory;
import com.duleendra.expensetracker.service.IncomeCategoryService;

@Controller
public class IncomeCategoryController {

	@Autowired
	IncomeCategoryService incomeCategoryService;
	
	@RequestMapping("/viewIncomeCategories")
	public ModelAndView viewIncomeCategories() {
		return new ModelAndView("income_category_list","incomeCategories",incomeCategoryService.getAllIncomeCategories());
	}
	
	@RequestMapping(value = "/newIncomeCategory.action", method = RequestMethod.GET)
	public String newCategory(Model model) {
		model.addAttribute("incomeCategorybject", new IncomeCategory());
		return "income_category_add";
	}
	
	@RequestMapping(value = "/saveIncomeCategory.action", method = RequestMethod.POST)
    public  ModelAndView saveCategory(@ModelAttribute("categoryObject") IncomeCategory incomeCategory, 
      Model model) {
		incomeCategoryService.saveIncomeCategory(incomeCategory);
		return new ModelAndView("redirect:/viewIncomeCategories.action");
	}
	
	@RequestMapping(value="/viewInomceCategory/{id}", method = RequestMethod.GET)
	public String viewInomceCategory(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		IncomeCategory incomeCategory = incomeCategoryService.findIncomeCategory(id);
		model.addAttribute("incomeCategoryObject", incomeCategory);
		return "income_category_edit";	
	}
	
	@RequestMapping(value="/deleteIncomeCategory/{id}", method = RequestMethod.GET)
	public  ModelAndView deleteIncomeCategory(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		incomeCategoryService.deleteIncomeCategory(id);
		return new ModelAndView("redirect:/viewIncomeCategories.action");
		
	}
}
