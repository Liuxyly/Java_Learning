package org.liuxy.rentcar.dao;

import java.util.List;

import org.liuxy.rentcar.entity.Brand;

public interface BrandDao {
	List<Brand> findAll();
	int addBrand(String brandName);
	Brand findBrandByName(Brand brand);
}
