package org.liuxy.rentcar.service.impl;

import java.io.InputStream;
import java.util.List;

import org.liuxy.rentcar.dao.BrandDao;
import org.liuxy.rentcar.dao.CarInfoDao;
import org.liuxy.rentcar.dao.CarTypeDao;
import org.liuxy.rentcar.dao.impl.BrandDaoImpl;
import org.liuxy.rentcar.dao.impl.CarInfoDaoImpl;
import org.liuxy.rentcar.dao.impl.CarTypeDaoImpl;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.entity.Page;
import org.liuxy.rentcar.service.CarInfoService;

public class CarInfoServiceImpl implements CarInfoService {
	
	CarInfoDao carInfoDao = new CarInfoDaoImpl();
	CarTypeDao carTypeDao = new CarTypeDaoImpl();
	BrandDao brandDao = new BrandDaoImpl();
	
	public CarInfoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CarInfo> listAllCarInfo() {
		return carInfoDao.findAll();
	}

	@Override
	public int addCarInfo(CarInfo carInfo) {
		Brand brand = carInfo.getCarType().getBrand();
		CarType carType = carInfo.getCarType();
		
		if (brandDao.findBrandByName(brand) == null) {
			brandDao.addBrand(carInfo.getCarType().getBrand().getBrandName());
		}
		
		Integer brandId = brandDao.findBrandByName(carInfo.getCarType().getBrand()).getBrandId();
		
		carType.getBrand().setBrandId(brandId);
		
		if (carTypeDao.findCarTypeBy(carType) == null) {
			carTypeDao.addCarType(carType);
		}
		Integer carTypeId = carTypeDao.findCarTypeBy(carType).getCartypeId();
		
		carInfo.getCarType().setCartypeId(carTypeId);
		
		return carInfoDao.addCarInfo(carInfo);
	}

	@Override
	public CarInfo findCarInfoByCarId(Integer carId) {
		return carInfoDao.findCarInfoByCarID(carId);
	}

	@Override
	public int deleteCarInfoByCarId(Integer carId) {
		
		int rows = carInfoDao.deleteCarInfoByCarID(carId);
		
		if (rows != 0) {
			carInfoDao.commitData();
		} else {
			carInfoDao.rollbackData();
		}
		
		return rows;
	}

	@Override
	public int addCarInfoNot(CarInfo carInfo) {
		
		int rows = carInfoDao.addCarInfo(carInfo);
		
		if (rows != 0) {
			carInfoDao.commitData();
		} else {
			carInfoDao.rollbackData();
		}
		
		return rows;
	}

	@Override
	public int updateCarInfoByCarId(CarInfo carInfo) {
		
		int rows = carInfoDao.updateCarInfo(carInfo);
		
		if (rows != 0) {
			carInfoDao.commitData();
		} else {
			carInfoDao.rollbackData();
		}
		
		return rows;
	}

	@Override
	public Page<CarInfo> listCarInfoByBrand(Brand brand, Integer page, Integer prePage) {
		
		int totalRow = carInfoDao.getCarInfoCount(brand);	//通过select count 取得总记录数
		Page<CarInfo> pageObj = new Page<>(totalRow, page);
		pageObj.setPageList(carInfoDao.findAllByBrand(brand, pageObj));
		
		return pageObj;
	}

	@Override
	public List<CarInfo> findAllBycondition(List<String> levels, List<String> brands, List<String> prices,
			String defaultSort, String RrlPriceSort, String stockOnlySort, Page<CarInfo> page) {
		return carInfoDao.findAllBycondition(levels, brands, prices, defaultSort, RrlPriceSort, stockOnlySort, page);
	}

	@Override
	public int getCarInfoCountByCondition(List<String> levels, List<String> brands, List<String> prices,
			String stockOnlySort) {
		return carInfoDao.getCarInfoCountByCondition(levels, brands, prices, stockOnlySort);
	}

	@Override
	public InputStream getImgByCarId(Integer carId) {
		return carInfoDao.getImgByCarId(carId);
	}

}
