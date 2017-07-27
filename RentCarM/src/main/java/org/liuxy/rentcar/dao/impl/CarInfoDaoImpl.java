package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.liuxy.rentcar.dao.CarInfoDao;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.entity.User;

public class CarInfoDaoImpl extends BaseDao implements CarInfoDao {

	public CarInfoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int updateCarInfo(CarInfo carInfo) {
		String sql = "UPDATE CarInfo "
				+ " SET cartypeId = ?, carJibie = ?, carJiegou = ?, carPailiang = ?, carBox = ?, carPeople = ?, price = ?, discount = ?, carImg = ?, carState = ?"
				+ " WHERE carId= ?";
		
		return this.dataUpdate(sql,
				carInfo.getCarType().getCartypeId(),
				carInfo.getCarJibie(),
				carInfo.getCarJiegou(),
				carInfo.getCarPailiang(),
				carInfo.getCarBox(),
				carInfo.getCarPeople(),
				carInfo.getPrice(),
				carInfo.getDiscount(),
				carInfo.getImageData(),
				carInfo.getCarState(),
				carInfo.getCarId()
				);
	}

	@Override
	public List<CarInfo> findAll() {
		List<CarInfo> list = new ArrayList<>();
		String sql = "SELECT b.brandId as brandId, carId, i.cartypeId as cartypeId, cartypeName, brandName,  carJibie, carJiegou, carPailiang, carBox, carPeople, price, discount, carImg, carState "
				+ " FROM RentCar.CarInfo as i, CarType as c, Brand as b WHERE c.cartypeId = i.cartypeId and b.brandId = c.brandId;";
		
		ResultSet rs = this.dataQuery(sql);
		
		try {
			CarInfo carInfo = null;
			CarType carType = null;
			Brand brand = null;
			
			while (rs.next()) {
				
				carInfo = new CarInfo();
				carInfo.setCarId(rs.getInt("carId"));
				
				carType = new CarType();
				carType.setCartypeName(rs.getString("cartypeName"));
				carType.setCartypeId(rs.getInt("cartypeId"));
				
				brand = new Brand();
				brand.setBrandName(rs.getString("brandName"));
				brand.setBrandId(rs.getInt("brandId"));
				carType.setBrand(brand);
				
				carInfo.setCarType(carType);
				carInfo.setCarJibie(rs.getString("carJibie"));
				carInfo.setCarJiegou(rs.getString("carJiegou"));
				carInfo.setCarPailiang(rs.getString("carPailiang"));
				carInfo.setCarBox(rs.getString("carBox"));
				carInfo.setCarPeople(rs.getInt("carPeople"));
				carInfo.setPrice(rs.getBigDecimal("price"));
				carInfo.setDiscount(rs.getBigDecimal("discount"));
				carInfo.setImageData(rs.getBinaryStream("carImg"));
				carInfo.setCarState(rs.getInt("carState"));
				
				list.add(carInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CarInfo> findAllByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCarInfo(CarInfo carInfo) {
		String sql = "INSERT INTO CarInfo(cartypeId, carJibie, carJiegou, carPailiang, carBox, carPeople, price, discount, carImg, carState) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		return this.dataUpdate(sql,
				carInfo.getCarType().getCartypeId(),
				carInfo.getCarJibie(),
				carInfo.getCarJiegou(),
				carInfo.getCarPailiang(),
				carInfo.getCarBox(),
				carInfo.getCarPeople(),
				carInfo.getPrice(),
				carInfo.getDiscount(),
				carInfo.getImageData(),
				carInfo.getCarState()
				);
	}

	@Override
	public CarInfo findCarInfoByCarID(Integer carId) {
		List<CarInfo> list = this.findAll();
		CarInfo carInfo = null;
		
		carInfo = list.stream().filter(c -> c.getCarId() == carId ).collect(Collectors.toList()).get(0);
		
		return carInfo;
	}

	@Override
	public int deleteCarInfoByCarID(Integer carId) {
		String sql = "DELETE FROM CarInfo WHERE carId = ?";
		return this.dataUpdate(sql, carId);
	}

}
