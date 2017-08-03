package org.liuxy.rentcar.service.impl;

import java.util.List;

import org.liuxy.rentcar.dao.CarInfoDao;
import org.liuxy.rentcar.dao.OrderDao;
import org.liuxy.rentcar.dao.impl.CarInfoDaoImpl;
import org.liuxy.rentcar.dao.impl.OrderDaoImpl;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	OrderDao orderDao = new OrderDaoImpl();
	CarInfoDao carInfoDao = new CarInfoDaoImpl();
	
	public OrderServiceImpl() {
	}

	@Override
	public List<Order> listOrders() {
		return orderDao.findAll();
	}

	@Override
	public int confirm(Integer orderState, Integer orderId) {
		return orderDao.updateOrderState(orderState, orderId);
	}

	@Override
	public int tradeOrder(Order order) {
		carInfoDao.updateCarState(order.getNormalUser().getUserId(), 0);
		
		return orderDao.addOrder(order);
	}

}
