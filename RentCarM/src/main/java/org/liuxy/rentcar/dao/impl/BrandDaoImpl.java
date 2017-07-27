package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.liuxy.rentcar.dao.BrandDao;
import org.liuxy.rentcar.entity.Brand;

public class BrandDaoImpl extends BaseDao implements BrandDao {

	public BrandDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Brand> findAll() {
		String sql = "SELECT brandId, brandName FROM Brand";
		List<Brand> list = new ArrayList<>();
		Brand brand = null;
		ResultSet rs = this.dataQuery(sql);
		
		try {
			while (rs.next()) {
				brand = new Brand();
				
				brand.setBrandId(rs.getInt("brandId"));
				brand.setBrandName(rs.getString("brandName"));
				
				list.add(brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addBrand(String brandName) {
		String sql = "INSERT INTO Brand(brandName) VALUES(?)";
		return this.dataUpdate(sql, brandName);
	}

	@Override
	public Brand findBrandByName(Brand brand) {
		StringBuffer sql = new StringBuffer("select brandId, brandName from Brand where brandName = ? ");
		ResultSet rs = null;
		if (brand.getBrandId() != null) {
			sql.append("and brandId = ?");
			rs = this.dataQuery(sql.toString(), brand.getBrandName(), brand.getBrandId());
		} else {
			rs = this.dataQuery(sql.toString(), brand.getBrandName());
		}
		
		Brand brandtmp = null;
		
		try {
			while (rs.next()) {
				brandtmp = new Brand();
				brandtmp.setBrandId(rs.getInt("brandId"));
				brandtmp.setBrandName(rs.getString("brandName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return brandtmp;
	}

}
