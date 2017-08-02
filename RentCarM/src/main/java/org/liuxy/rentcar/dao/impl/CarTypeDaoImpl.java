package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.liuxy.rentcar.dao.CarInfoDao;
import org.liuxy.rentcar.dao.CarTypeDao;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.entity.User;

public class CarTypeDaoImpl extends BaseDao implements CarTypeDao {

	public CarTypeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addCarType(CarType carType) {
		String updatesql = "INSERT INTO CarType(brandId, cartypeName) VALUES (?, ?)";
		return this.dataUpdate(updatesql, carType.getBrand().getBrandId(), carType.getCartypeName());
	}

	@Override
	public CarType findCarTypeBy(CarType carType) {
		String selectsql = "SELECT b.brandId as brandID, cartypeId, brandName, cartypeName FROM CarType as c, Brand as b"
				+ " WHERE b.brandId = c.brandId and brandName = ? and cartypeName = ? and b.brandId = ?";
		ResultSet rs = this.dataQuery(selectsql, carType.getBrand().getBrandName(), carType.getCartypeName(), carType.getBrand().getBrandId());
		CarType carTypeTmp = null;
		Brand brand = null;
		
		try {
			while (rs.next()) {
				brand = new Brand();
				brand.setBrandId(rs.getInt("brandID"));
				brand.setBrandName(rs.getString("brandName"));
				
				carTypeTmp = new CarType();
				carTypeTmp.setBrand(brand);
				carTypeTmp.setCartypeId(rs.getInt("cartypeId"));
				carTypeTmp.setCartypeName(rs.getString("cartypeName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		
		return carTypeTmp;
	}

	@Override
	public List<CarType> findCarTypeByBrandId(Integer brandId) {
		String sql = "SELECT cartypeId, cartypeName FROM RentCar.CarType WHERE brandId = ?";
		ResultSet rs = this.dataQuery(sql, brandId);
		CarType carType = null;
		List<CarType> list = new ArrayList<>();
		try {
			while (rs.next()) {
				carType = new CarType();
				carType.setCartypeId(rs.getInt("cartypeId"));
				carType.setCartypeName(rs.getString("cartypeName"));
				list.add(carType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		
		return list;
	}

	@Override
	public CarType findCarType(CarType carType) {
		String sql = "SELECT cartypeId, brandId, cartypeName FROM CarType where cartypeName = ?";
		ResultSet rs = this.dataQuery(sql, carType.getCartypeName());
		CarType carTypeTmp = null;
		Brand brand = null;
		
		try {
			while (rs.next()) {
				brand = new Brand();
				carTypeTmp = new CarType();
				carTypeTmp.setCartypeId(rs.getInt("cartypeId"));
				brand.setBrandId(rs.getInt("brandId"));
				carTypeTmp.setBrand(brand);
				carTypeTmp.setCartypeName(rs.getString("cartypeName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		
		return carTypeTmp;
	}

	

}
