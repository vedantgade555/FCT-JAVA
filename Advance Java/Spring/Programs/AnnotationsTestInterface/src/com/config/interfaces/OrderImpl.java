package com.config.interfaces;

public class OrderImpl implements OrderInterface {

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
