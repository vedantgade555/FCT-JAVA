package com.vedant.gade.SpringAopDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Make sure to import your AppConfig and PaymentService!
import com.vedant.gade.AppConfig;
import com.vedant.gade.service.PaymentService;

public class App {
	public static void main(String[] args) {
		
		// 1. THIS IS THE CRITICAL LINE: Pass AppConfig.class here!
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// 2. Fetch the bean
		PaymentService paymentService = context.getBean(PaymentService.class);
		
		// 3. Execute the method
		paymentService.processPayment();
	}
}