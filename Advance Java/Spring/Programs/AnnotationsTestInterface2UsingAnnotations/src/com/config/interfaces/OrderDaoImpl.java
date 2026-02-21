package com.config.interfaces;

import org.springframework.stereotype.Component;

@Component("dao1")
public class OrderDaoImpl implements OrderDAOInterface {

	private OrderInterface order;
	
	@Override
	public void createOrder() {
		System.out.println("Inside OrderDaoImpl class");

	}

}
