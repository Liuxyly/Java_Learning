package org.liuxy.rentcar.dao;

import java.util.List;

import org.liuxy.rentcar.entity.CarType;

public interface CarTypeDao {
	int addCarType(CarType carType);
	CarType findCarTypeBy(CarType carType);
	List<CarType> findCarTypeByBrandId(Integer brandId);
	CarType findCarType(CarType carType);
	
	void commitData();
	void rollbackData();
}
