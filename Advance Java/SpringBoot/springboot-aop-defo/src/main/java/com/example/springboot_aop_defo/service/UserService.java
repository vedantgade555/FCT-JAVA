package com.example.springboot_aop_defo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	public String getUserInfo() {
		System.out.println("Inside UserInfo method");
		return "User Details";
	}
}
