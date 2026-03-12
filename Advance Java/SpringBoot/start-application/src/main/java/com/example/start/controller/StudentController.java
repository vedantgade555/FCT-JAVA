package com.example.start.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.start.bean.Student;

@RestController
public class StudentController {
	@GetMapping("/welcome")
	public String Welcome() 
	{
		return "My First SpringBoot Application";
	}
	
	@GetMapping("/get")
	public Student get() {
		Student s = new Student(101,"Ram",98.30);
		return s;
	}
	
	@GetMapping("/findAll")
	public List<Student> findAll(){
		List<Student> l1 = new ArrayList<Student>();
		l1.add(new Student(101,"Raj",50.55));
		l1.add(new Student(102,"Raj",50.55));
		l1.add(new Student(103,"Raj",50.55));
		l1.add(new Student(104,"Raj",50.55));
		l1.add(new Student(105,"Raj",50.55));
		
		return l1;
	}
}
