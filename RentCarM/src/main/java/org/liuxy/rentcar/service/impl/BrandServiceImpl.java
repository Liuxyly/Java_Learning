package org.liuxy.rentcar.service.impl;

import java.util.List;

import org.liuxy.rentcar.dao.BrandDao;
import org.liuxy.rentcar.dao.impl.BrandDaoImpl;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.service.BrandService;

public class BrandServiceImpl implements BrandService {

	BrandDao brandDao = new BrandDaoImpl();
	
	public BrandServiceImpl() {
		
	}
	
	@Override
	public List<Brand> brandNameOptions() {
		return brandDao.findAll();
	}

	@Override
	public int addBrandName(String brandName) {
		return brandDao.addBrand(brandName);
	}

	@Override
	public Brand getBrandByBrandName(Brand brand) {
		return brandDao.findBrandByName(brand);
	}

}
