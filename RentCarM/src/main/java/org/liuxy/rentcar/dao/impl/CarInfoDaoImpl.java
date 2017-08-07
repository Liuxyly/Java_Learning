package org.liuxy.rentcar.dao.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.liuxy.rentcar.dao.CarInfoDao;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.entity.Page;
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
		
		try {
			if (carInfo.getImageData().available() == 0) {
				carInfo.setImageData(this.getImgByCarId(carInfo.getCarId()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		} finally {
			this.closeAll();
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
	
	@Override
	public int getCarInfoCount(Brand brand) {
		
		StringBuffer sqlB = new StringBuffer("select count(1) as count from CarInfo ");
		int count = 0;
		ResultSet rs = null;
		
		if (brand != null) {
			sqlB.append("as c, Brand as b, CarType as i where i.cartypeId = c.cartypeId and b.brandId = i.brandId and brandName = ? ");
			rs = this.dataQuery(sqlB.toString(), brand.getBrandName());
		} else {
			rs = this.dataQuery(sqlB.toString());
		}
		try {
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		
		return count;
	}

	@Override
	public List<CarInfo> findAllByBrand(Brand brand, Page<CarInfo> page) {
		
		StringBuffer sqlB = new StringBuffer("SELECT carId, i.cartypeId as cartypeId, i.cartypeName as cartypeName, b.brandId as brandId, b.brandName as brandName, carJibie, carJiegou, carPailiang, carBox, carPeople, price, discount, carState "
				+ " FROM CarInfo as c, Brand as b, CarType as i where i.cartypeId = c.cartypeId and b.brandId = i.brandId and 1=1 ");
		
		ResultSet rs = null;
		
		if (brand != null) {
			sqlB.append("and b.brandName = ? ");
			sqlB.append("limit ?, ? ");
			rs = this.dataQuery(sqlB.toString(), brand.getBrandName(), page.getBeginIndex(), page.getEndIndex());
		} else {
			sqlB.append("limit ?, ? ");
			rs = this.dataQuery(sqlB.toString(), page.getBeginIndex(), page.getEndIndex());
		}
		
		List<CarInfo> list = new ArrayList<>();
		
		try {
			CarInfo carInfo = null;
			CarType carType = null;
			Brand brandtmp = null;
			
			while (rs.next()) {
				carInfo = new CarInfo();
				carInfo.setCarId(rs.getInt("carId"));
				
				carType = new CarType();
				carType.setCartypeName(rs.getString("cartypeName"));
				carType.setCartypeId(rs.getInt("cartypeId"));
				
				brandtmp = new Brand();
				brandtmp.setBrandName(rs.getString("brandName"));
				brandtmp.setBrandId(rs.getInt("brandId"));
				carType.setBrand(brandtmp);
				
				carInfo.setCarType(carType);
				carInfo.setCarJibie(rs.getString("carJibie"));
				carInfo.setCarJiegou(rs.getString("carJiegou"));
				carInfo.setCarPailiang(rs.getString("carPailiang"));
				carInfo.setCarBox(rs.getString("carBox"));
				carInfo.setCarPeople(rs.getInt("carPeople"));
				carInfo.setPrice(rs.getBigDecimal("price"));
				carInfo.setDiscount(rs.getBigDecimal("discount"));
				// carInfo.setImageData(rs.getBinaryStream("carImg"));
				carInfo.setCarState(rs.getInt("carState"));
				
				list.add(carInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		
		return list;
	}

	@Override
	public List<CarInfo> findAllBycondition(List<String> levels, List<String> brands, List<String> prices,
			String defaultSort, String RrlPriceSort, String stockOnlySort, Page<CarInfo> page) {
		
		StringBuffer sqlB = new StringBuffer("SELECT carId, i.cartypeId as cartypeId, i.cartypeName as cartypeName, b.brandId as brandId, b.brandName as brandName, carJibie, carJiegou, carPailiang, carBox, carPeople, price, discount, (price * discount * 0.01) as realprice, carState "
				+ " FROM CarInfo as c, Brand as b, CarType as i where i.cartypeId = c.cartypeId and b.brandId = i.brandId and 1=1 ");
		
		HashMap<String, List<String>> condetionMap = new HashMap<>();
		HashMap<String, List<String>> sectionMap = new HashMap<>();
		ResultSet rs = null;
		
		List<String> stockOnlys = null;
		
		if (Boolean.parseBoolean(stockOnlySort)) {
			stockOnlys = new ArrayList<>();
			stockOnlys.add("1");
		}
		
		if (stockOnlys != null && !stockOnlys.isEmpty()) {
			condetionMap.put("carState", stockOnlys);
		}
		
		if (levels != null && !levels.isEmpty()) {
			condetionMap.put("carJibie", (List<String>)levels);
		}
		
		if (brands != null && !brands.isEmpty()) {
			condetionMap.put("b.brandId", (List<String>)brands);
		}
		
		if (prices != null && !prices.isEmpty()) {
			sectionMap.put("price", (List<String>)prices);
		}
		
		List<String> orderBy = new ArrayList<>();
		
		if (Boolean.parseBoolean(defaultSort)) {
			orderBy.add("carId");
		}
		
		if (Boolean.parseBoolean(RrlPriceSort)) {
			orderBy.add("realprice");
		}
		
		rs = this.dataQueryByCondition(sqlB.toString(), condetionMap, sectionMap, page, orderBy);
		
		List<CarInfo> list = new ArrayList<>();
		
		try {
			CarInfo carInfo = null;
			CarType carType = null;
			Brand brandtmp = null;
			
			while (rs.next()) {
				carInfo = new CarInfo();
				carInfo.setCarId(rs.getInt("carId"));
				
				carType = new CarType();
				carType.setCartypeName(rs.getString("cartypeName"));
				carType.setCartypeId(rs.getInt("cartypeId"));
				
				brandtmp = new Brand();
				brandtmp.setBrandName(rs.getString("brandName"));
				brandtmp.setBrandId(rs.getInt("brandId"));
				carType.setBrand(brandtmp);
				
				carInfo.setCarType(carType);
				carInfo.setCarJibie(rs.getString("carJibie"));
				carInfo.setCarJiegou(rs.getString("carJiegou"));
				carInfo.setCarPailiang(rs.getString("carPailiang"));
				carInfo.setCarBox(rs.getString("carBox"));
				carInfo.setCarPeople(rs.getInt("carPeople"));
				carInfo.setPrice(rs.getBigDecimal("price"));
				carInfo.setDiscount(rs.getBigDecimal("discount"));
				// carInfo.setImageData(rs.getBinaryStream("carImg"));
				carInfo.setCarState(rs.getInt("carState"));
				
				list.add(carInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		
		return list;
	}

	@Override
	public int getCarInfoCountByCondition(List<String> levels, List<String> brands, List<String> prices,
			String stockOnlySort) {
		StringBuffer sqlB = new StringBuffer("SELECT count(1) as countNumber "
				+ " FROM CarInfo as c, Brand as b, CarType as i where i.cartypeId = c.cartypeId and b.brandId = i.brandId and 1=1 ");
		
		HashMap<String, List<String>> condetionMap = new HashMap<>();
		
		HashMap<String, List<String>> sectionMap = new HashMap<>();
		ResultSet rs = null;
		
		List<String> stockOnlys = null;
		
		if (Boolean.parseBoolean(stockOnlySort)) {
			stockOnlys = new ArrayList<>();
			stockOnlys.add("1");
		}
		
		if (stockOnlys != null && !stockOnlys.isEmpty()) {
			condetionMap.put("carState", stockOnlys);
		}
		
		if (levels != null && !levels.isEmpty()) {
			condetionMap.put("carJibie", (List<String>)levels);
		}
		
		if (brands != null && !brands.isEmpty()) {
			condetionMap.put("b.brandId", (List<String>)brands);
		}
		
		if (prices != null && !prices.isEmpty()) {
			sectionMap.put("price", (List<String>)prices);
		}
		
		rs = this.dataQueryByCondition(sqlB.toString(), condetionMap, sectionMap, null, null);
		
		int count = 0;
		
		try {
			while (rs.next()) {
				count = rs.getInt("countNumber");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		
		return count;
	}

	@Override
	public InputStream getImgByCarId(Integer carId) {
		
		String sql = " select carImg from CarInfo where carId = ? ";
		
		ResultSet rs = this.dataQuery(sql, carId);
		
		InputStream inputStream = null;
		
		try {
			if (rs.next()) {
				inputStream = rs.getBinaryStream("carImg");
				return inputStream;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			this.closeAll();
		}
	}

	@Override
	public int updateCarState(Integer carId, Integer carState) {
		String sql = "UPDATE CarInfo SET carState = ? WHERE carId = ?";
		return this.dataUpdate(sql, carState, carId);
	}
	
	

}
