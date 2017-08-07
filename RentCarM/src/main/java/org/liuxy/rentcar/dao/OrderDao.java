package org.liuxy.rentcar.dao;

import java.util.List;

import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.entity.Page;

public interface OrderDao extends Connectable {
	
	// Normal User
	List<Order> findByCondsion(List<String> userId, List<String> orderState, List<String> brandId, Page<Order> page);
	int getOrderInfoCountByCondition(List<String> userId, List<String> orderState, List<String> brandId);
	
	// Adminerator
	List<Order> findByCondsion(List<String> userName, List<String> orderState, List<String> brandId, List<String> orderId, Page<Order> page);
	int getOrderCountByCondition(List<String> userId, List<String> orderState, List<String> brandId, List<String> orderId);
	
	int updateOrderState(Integer orderState, Long orderId);
	
	int updateOrderByOrder(Order order);
	
	int addOrder(Order order);
	void commitData();
	void rollbackData();
	Order findOrderWithOrderState(Order order);
	
	Order findOrderbyCarId(Integer carId);
	Order findOrderByOrderIdAndUserId(Long orderId, Integer userId);
	
	
	
	int cancelOrderByOrderId(Long orderId, Integer userId, Integer carId);
	
	int closeOrderByOrderId(Long orderId, Integer userId, Integer carId);
}
