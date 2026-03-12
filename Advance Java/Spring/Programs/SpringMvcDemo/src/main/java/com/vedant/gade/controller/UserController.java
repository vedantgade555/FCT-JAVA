package com.vedant.gade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vedant.gade.dao.User;

@Controller
public class UserController {

	@GetMapping("/UserReg")
	public ModelAndView showRegistrationPage(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserReg");
		
		return mv;
	}
	
	
	@RequestMapping(value="registerUser",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user)
	{
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("user");
		return mv;
	}
}
