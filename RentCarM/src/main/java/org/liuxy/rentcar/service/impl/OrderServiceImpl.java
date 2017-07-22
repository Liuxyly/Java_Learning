package org.liuxy.rentcar.service.impl;

import java.util.List;

import org.liuxy.rentcar.dao.OrderDao;
import org.liuxy.rentcar.dao.impl.OrderDaoImpl;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	OrderDao orderDao = new OrderDaoImpl();
	
	public OrderServiceImpl() {
	}

	@Override
	public List<Order> listOrders() {
		return orderDao.findAll();
	}

}
