package com.vedant.gade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView home(Model model)
	{
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("home");
		modelandview.addObject("Name","Vedant");
		modelandview.addObject("id",101);
		modelandview.addObject("Salary",88000);
		return modelandview;
	}
	
}
