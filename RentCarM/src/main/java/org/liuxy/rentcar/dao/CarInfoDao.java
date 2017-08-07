package org.liuxy.rentcar.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.Page;
import org.liuxy.rentcar.entity.User;

public interface CarInfoDao extends Connectable {

	int updateCarInfo(CarInfo carInfo);
	
	List<CarInfo> findAll();
	
	List<CarInfo> findAllBycondition(List<String> levels, List<String> brands, List<String> prices, String defaultSort, String RrlPriceSort, String stockOnlySort, Page<CarInfo> page);
	
	List<CarInfo> findAllByUser(User user);
	
	List<CarInfo> findAllByBrand(Brand brand, Page<CarInfo> page);
	
	int addCarInfo(CarInfo carInfo);
	
	CarInfo findCarInfoByCarID(Integer carId);
	
	int deleteCarInfoByCarID(Integer carId);
	
	int getCarInfoCount(Brand brand);
	
	int getCarInfoCountByCondition(List<String> levels, List<String> brands, List<String> prices, String stockOnlySort);
	
	InputStream getImgByCarId(Integer carId);
	
	int updateCarState(Integer carId, Integer carState);
	
	void commitData();
	void rollbackData();
}
