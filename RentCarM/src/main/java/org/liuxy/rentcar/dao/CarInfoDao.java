package org.liuxy.rentcar.dao;

import java.util.List;

import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.User;

public interface CarInfoDao {

	int updateCarInfo(CarInfo carInfo);
	
	List<CarInfo> findAll();
	
	List<CarInfo> findAllByUser(User user);
	
	int addCarInfo(CarInfo carInfo);
	
	CarInfo findCarInfoByCarID(Integer carId);
	
	int deleteCarInfoByCarID(Integer carId);
}
