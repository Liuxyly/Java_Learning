package org.liuxy.rentcar.service.impl;

import java.util.List;

import org.liuxy.rentcar.dao.CarTypeDao;
import org.liuxy.rentcar.dao.impl.CarTypeDaoImpl;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.service.CarTypeService;

public class CarTypeServiceImpl implements CarTypeService {
	
	private CarTypeDao carTypeDao = new CarTypeDaoImpl();
	
	public CarTypeServiceImpl() {
	}

	@Override
	public List<CarType> getCarTypeOptionsByBrandID(Integer brandId) {
		return carTypeDao.findCarTypeByBrandId(brandId);
	}

	@Override
	public int addCarType(CarType carType) {
		return carTypeDao.addCarType(carType);
	}

	@Override
	public CarType findCarType(CarType carType) {
		return carTypeDao.findCarType(carType);
	}
	
	
}
