package com.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 
		 System.out.println(context.getBean("employee1"));
	}
}
