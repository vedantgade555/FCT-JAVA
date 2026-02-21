package com.config.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("oi")
public class OrderImpl implements OrderInterface {

	@Autowired
	@Qualifier
	private OrderDAOInterface dao;
	
	

	public OrderDAOInterface getDao() {
		return dao;
	}

	public void setDao(OrderDAOInterface dao) {
		this.dao = dao;
	}
	
	@Override
	public void placeOrder() {
		System.out.println("Inside OrderImpl Class");
		dao.createOrder();

	}
	

}
