package org.liuxy.rentcar.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.liuxy.rentcar.dao.CarInfoDao;
import org.liuxy.rentcar.dao.OrderDao;
import org.liuxy.rentcar.dao.impl.CarInfoDaoImpl;
import org.liuxy.rentcar.dao.impl.OrderDaoImpl;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.entity.Page;
import org.liuxy.rentcar.service.OrderService;
import org.liuxy.util.DBManager;

public class OrderServiceImpl implements OrderService {
	
	private final int RENT = 0;
	private final int SINECURE = 1;
	
	OrderDao orderDao = new OrderDaoImpl();
	CarInfoDao carInfoDao = new CarInfoDaoImpl();
	
	public OrderServiceImpl() {
	}

	@Override
	public int confirm(Integer orderState, Long orderId) {
		
		int row = orderDao.updateOrderState(orderState, orderId);
		
		if (row != 0) {
			orderDao.commitData();
		} else {
			orderDao.rollbackData();
		}
		
		return row;
	}

	@Override
	public int tradeOrder(Order order) {
		
		Connection connection = DBManager.getConn();
		
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		carInfoDao.setConnection(connection);
		
		int rows1 = carInfoDao.updateCarState(order.getCarInfo().getCarId(), RENT);
		
		orderDao.setConnection(connection);
		
		int rows2 = orderDao.addOrder(order);
		try {
			if (rows1 != 0 && rows2 != 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows2;
	}

	@Override
	public Order findOrderWithOrderState(Order order) {
		return orderDao.findOrderWithOrderState(order);
	}

	@Override
	public Order findOrderByCarId(Integer carId) {
		return orderDao.findOrderbyCarId(carId);
	}

	@Override
	public Order findOrderByOrderIdAndUserId(Long orderId, Integer userId) {
		return orderDao.findOrderByOrderIdAndUserId(orderId, userId);
	}

	@Override
	public List<Order> findOrdersByCondition(List<String> userId, List<String> orderState, List<String> brandId, Page<Order> page) {
		return orderDao.findByCondsion(userId, orderState, brandId, page);
	}

	@Override
	public int getOrderCountByCondition(List<String> userId, List<String> orderState, List<String> brandId) {
		return orderDao.getOrderInfoCountByCondition(userId, orderState, brandId);
	}

	@Override
	public int cancelOrderByOrderId(Long orderId, Integer userId, Integer carId) {
		
		Connection connection = DBManager.getConn();
		
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		orderDao.setConnection(connection);
		
		int rows1 = orderDao.cancelOrderByOrderId(orderId, userId, carId);
		
		carInfoDao.setConnection(connection);
		
		int rows2 = carInfoDao.updateCarState(carId, SINECURE);
		
		try {
			if (rows1 != 0 && rows2 != 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows1; 
	}

	@Override
	public int updateOrderInfo(Order order) {
		return orderDao.updateOrderByOrder(order);
	}

	@Override
	public int getOrderCountByCondition(List<String> userName, List<String> orderState, List<String> brandId,
			List<String> orderId) {
		
		return orderDao.getOrderCountByCondition(userName, orderState, brandId, orderId);
	}

	@Override
	public List<Order> findOrdersByCondition(List<String> userName, List<String> orderState, List<String> brandId,
			List<String> orderId, Page<Order> page) {
		return orderDao.findByCondsion(userName, orderState, brandId, orderId, page);
	}

	@Override
	public int closeOrderByOrderId(Long orderId, Integer userId, Integer carId) {
		Connection connection = DBManager.getConn();
		
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		orderDao.setConnection(connection);
		
		int rows1 = orderDao.closeOrderByOrderId(orderId, userId, carId);
		
		carInfoDao.setConnection(connection);
		
		int rows2 = carInfoDao.updateCarState(carId, SINECURE);
		
		try {
			if (rows1 != 0 && rows2 != 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows1; 
	}

}
