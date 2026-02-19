package com.vedant.gade.externalization.SpringExternalization;

import java.applet.AppletContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		MyDao dao = (MyDao)context.getBean("mydao");
		System.out.println(dao);
		
	}
}

