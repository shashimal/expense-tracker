package com.duleendra.expensetracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.duleendra.expensetracker.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/viewCatogories.action")
	public ModelAndView viewCatogories(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		List<Category> categories = categoryService.getAllCategories();
		return new ModelAndView("category_list", "categories", categories);
	}

	@RequestMapping(value = "/newCategory.action", method = RequestMethod.GET)
	public String newCategory(Model model) {
		model.addAttribute("categoryObject", new Category());
		return "category_create";
	}
	
	@RequestMapping(value = "/saveCategory.action", method = RequestMethod.POST)
    public  ModelAndView saveCategory(@ModelAttribute("categoryObject") Category category, 
      Model model) {
		categoryService.saveCategory(category);
		return new ModelAndView("redirect:/viewCatogories.action");
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String viewCategory(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("categoryObject", category);
		
		return "category_edit";
		
	}
	
	@RequestMapping(value="/deleteCategory/{id}", method = RequestMethod.GET)
	public  ModelAndView deleteCategory(@PathVariable int id, HttpSession session,
			HttpServletResponse response,Model model) {
		categoryService.deleteCategory(id);
		
		return new ModelAndView("redirect:/viewCatogories.action");
		
	}
}
