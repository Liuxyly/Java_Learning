package org.liuxy.rentcar.impl.test;

import org.junit.Test;
import org.liuxy.rentcar.dao.CarInfoDao;
import org.liuxy.rentcar.dao.OrderDao;
import org.liuxy.rentcar.dao.impl.CarInfoDaoImpl;
import org.liuxy.rentcar.dao.impl.OrderDaoImpl;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.entity.Page;

public class OrderDaoImplTest {

	@Test
	public void test() {
//		OrderDao orderDao = new OrderDaoImpl();
//		
//		orderDao.findAll().forEach((Order o) -> {
//			System.out.println(o.getCarInfo().getCarId());
//		});
		
		CarInfoDao carInfoDao = new CarInfoDaoImpl();
		
		Brand brand = new Brand();
		brand.setBrandName("奥迪");
		
		Page<CarInfo> page = new Page<>(carInfoDao.getCarInfoCount(brand), 1, 3);
		page.setPageList(carInfoDao.findAllByBrand(brand, page));
		
		page.getPageList().forEach((CarInfo c) -> {
			System.out.println(c.getCarBox() + c.getCarJibie());
		});
	}

}

