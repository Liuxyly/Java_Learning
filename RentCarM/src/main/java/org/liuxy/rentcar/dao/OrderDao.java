package org.liuxy.rentcar.dao;

import java.util.List;

import org.liuxy.rentcar.entity.Order;

public interface OrderDao {
	List<Order> findAll();
	int updateOrderState(Integer orderState, Integer orderId);
}
