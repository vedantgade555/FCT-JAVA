package com.vedant.gade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vedant.gade.dao.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/student")
	public ModelAndView getStudent(Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student");
		
		List<Student> li = new ArrayList<Student>();
		Student s1  =new Student(101,"Ram",21);
		Student s2  =new Student(103,"Ramesh",21);
		Student s3  =new Student(102,"Raj",21);
		
		li.add(s1);
		li.add(s2);
		li.add(s3);
		
		mv.addObject("studentlist",li);
		
		return mv;
	}

}
