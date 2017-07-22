package org.liuxy.rentcar.dao;

import java.util.List;

import org.liuxy.rentcar.entity.CarInfo;

public interface CarInfoDao {

	int updateCarInfo(CarInfo carInfo);
	
	List<CarInfo> findAll();
}
