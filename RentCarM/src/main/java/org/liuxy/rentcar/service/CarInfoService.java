package org.liuxy.rentcar.service;

import java.util.List;

import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.Page;

public interface CarInfoService {
	List<CarInfo> listAllCarInfo();
	int addCarInfo(CarInfo carInfo);
	int addCarInfoNot(CarInfo carInfo);
	CarInfo findCarInfoByCarId(Integer carId);
	int deleteCarInfoByCarId(Integer carId);
	int updateCarInfoByCarId(CarInfo carInfo);
	Page<CarInfo> listCarInfoByBrand(Brand brand, Integer page, Integer prePage);
}
