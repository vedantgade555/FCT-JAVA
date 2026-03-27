package com.vedant.form_base_and_session_base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/hey")
	public String hey() {
		return "Hey World";
	}
	
	
	
}
