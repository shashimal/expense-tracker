package com.duleendra.expensetracker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/index.action")
	public ModelAndView viewCategoryList(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		return new ModelAndView("index", "model", "");
	}
}
