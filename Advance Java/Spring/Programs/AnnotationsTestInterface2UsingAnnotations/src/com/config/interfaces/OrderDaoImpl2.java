package com.config.interfaces;

import org.springframework.stereotype.Component;

@Component("dao2")
public class OrderDaoImpl2 implements OrderDAOInterface {

	@Override
	public void createOrder() {
		// TODO Auto-generated method stub
		System.out.println("Inside OrderDaoImpl2 class");

	}

}
