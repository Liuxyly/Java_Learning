package org.liuxy.rentcar.service;

import java.util.List;

import org.liuxy.rentcar.entity.CarType;

public interface CarTypeService {
	List<CarType> getCarTypeOptionsByBrandID(Integer brandId);
	int addCarType(CarType carType);
	CarType findCarType(CarType carType);
}
