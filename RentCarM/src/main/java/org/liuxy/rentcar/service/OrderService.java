package org.liuxy.rentcar.service;

import java.util.List;

import org.liuxy.rentcar.entity.Order;

public interface OrderService {
	List<Order> listOrders();
	int confirm(Integer orderState, Integer orderId);
	int tradeOrder(Order order);
}
