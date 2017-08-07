package org.liuxy.rentcar.service;

import java.util.List;

import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.entity.Page;

public interface OrderService {
	int confirm(Integer orderState, Long orderId);
	int tradeOrder(Order order);
	Order findOrderWithOrderState(Order order);
	
	int updateOrderInfo(Order order);
	
	Order findOrderByCarId(Integer carId);
	Order findOrderByOrderIdAndUserId(Long orderId, Integer userId);
	
	// Normal User
	List<Order> findOrdersByCondition(List<String> userId, List<String> orderState, List<String> brandId, Page<Order> page);
	int getOrderCountByCondition(List<String> userId, List<String> orderState, List<String> brandId);
	
	// Adminerator
	List<Order> findOrdersByCondition(List<String> userName, List<String> orderState, List<String> brandId, List<String> orderId, Page<Order> page);
	int getOrderCountByCondition(List<String> userName, List<String> orderState, List<String> brandId, List<String> orderId);
	
	int cancelOrderByOrderId(Long orderId, Integer userId, Integer carId);
	
	int closeOrderByOrderId(Long orderId, Integer userId, Integer carId);
}
