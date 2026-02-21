package com.config.interfaces;

public class OrderDaoImpl implements OrderDAOInterface {

	private OrderInterface order;
	
	@Override
	public void createOrder() {
		System.out.println("Inside OrderDaoImpl class");

	}

}
