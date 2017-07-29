package org.liuxy.rentcar.dao;

import java.util.List;

import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.Page;
import org.liuxy.rentcar.entity.User;

public interface CarInfoDao {

	int updateCarInfo(CarInfo carInfo);
	
	List<CarInfo> findAll();
	
	List<CarInfo> findAllByUser(User user);
	
	List<CarInfo> findAllByBrand(Brand brand, Page<CarInfo> page);
	
	int addCarInfo(CarInfo carInfo);
	
	CarInfo findCarInfoByCarID(Integer carId);
	
	int deleteCarInfoByCarID(Integer carId);
	
	int getCarInfoCount(Brand brand);
}
