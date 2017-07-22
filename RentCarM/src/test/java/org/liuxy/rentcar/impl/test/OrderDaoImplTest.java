package org.liuxy.rentcar.impl.test;

import org.junit.Test;
import org.liuxy.rentcar.dao.OrderDao;
import org.liuxy.rentcar.dao.impl.OrderDaoImpl;
import org.liuxy.rentcar.entity.Order;

public class OrderDaoImplTest {

	@Test
	public void test() {
		OrderDao orderDao = new OrderDaoImpl();
		
		orderDao.findAll().forEach((Order o) -> {
			System.out.println(o.getCarInfo().getCarId());
		});
	}

}
