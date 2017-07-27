package org.liuxy.rentcar.service;

import java.util.List;

import org.liuxy.rentcar.entity.Brand;

public interface BrandService {
	List<Brand> brandNameOptions();
	int addBrandName(String brandName);
	Brand getBrandByBrandName(Brand brand);
}
