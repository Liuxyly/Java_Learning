package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.liuxy.rentcar.dao.OrderDao;
import org.liuxy.rentcar.entity.Brand;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.Order;
import org.liuxy.rentcar.entity.Page;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	public OrderDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Order> findByCondsion(List<String> userId, List<String> orderState, List<String> brandId,
			Page<Order> page) {
		List<Order> list = new ArrayList<Order>();
		
		StringBuffer sqlB = new StringBuffer("SELECT userName, u.userid as userid, orderId, c.carId as carId, brandName, b.brandId as brandId, c.cartypeId as cartypeId, i.cartypeName as cartypeName, carJibie, carJiegou, carPailiang, getDate, getAddress, reAddress, reDate, carBox, carPeople, fee, orderState");
		sqlB.append(" FROM `Order` as o, CarInfo as c, Brand as b, CarType as i, Users as u where u.userid = o.userid and o.carId = c.carId and i.cartypeId = c.cartypeId and b.brandId = i.brandId and 1=1");
		HashMap<String, List<String>> condetionMap = new HashMap<>();
		
		if (userId != null && !userId.isEmpty()) {
			condetionMap.put("u.userid", userId);
		}
		
		if (orderState != null && !orderState.isEmpty()) {
			condetionMap.put("orderState", orderState);
		}
		
		if (brandId != null && !brandId.isEmpty()) {
			condetionMap.put("b.brandId", brandId);
		}
		
		List<String> orderBy = new ArrayList<>();
		orderBy.add("orderId DESC");
		
		ResultSet rs = this.dataQueryByCondition(sqlB.toString(), condetionMap, null, page, orderBy);
		try {
			Order order = null;
			CarInfo carInfo = null;
			NormalUser normalUser = null;
			CarType carType = null;
			Brand brand = null;
			while (rs.next()){
				order = new Order();
				order.setOrderId(rs.getLong("orderId"));
				carInfo = new CarInfo();
				carInfo.setCarId(rs.getInt("carId"));
				carInfo.setCarBox(rs.getString("carBox"));
				carInfo.setCarJibie(rs.getString("carJibie"));
				carInfo.setCarJiegou(rs.getString("carJiegou"));
				carInfo.setCarPailiang(rs.getString("carPailiang"));
				carInfo.setCarPeople(rs.getInt("carPeople"));
				order.setCarInfo(carInfo);
				order.setGetDate(rs.getDate("getDate"));
				order.setReDate(rs.getDate("reDate"));
				order.setGetAddress(rs.getString("getAddress"));
				order.setReAddress(rs.getString("reAddress"));
				order.setFee(rs.getBigDecimal("fee"));
				order.setOrderState(rs.getInt("orderState"));
				normalUser = new NormalUser();
				normalUser.setUserId(rs.getInt("userid"));
				normalUser.setUserName(rs.getString("userName"));
				order.setNormalUser(normalUser);
				carType = new CarType();
				carType.setCartypeId(rs.getInt("cartypeId"));
				carType.setCartypeName(rs.getString("cartypeName"));
				brand = new Brand();
				brand.setBrandName(rs.getString("brandName"));
				brand.setBrandId(rs.getInt("brandId"));
				carType.setBrand(brand);
				order.setCarType(carType);
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public int updateOrderState(Integer orderState, Long orderId) {
		String sql = "UPDATE `Order` SET orderState = ? WHERE orderId = ?;";
		return this.dataUpdate(sql, orderState, orderId);
	}

	@Override
	public int addOrder(Order order) {
		String sql = "INSERT INTO `Order` (userid, carId, getDate, reDate, getAddress, reAddress, fee, orderState) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		return this.dataUpdate(sql,
				order.getNormalUser().getUserId(),
				order.getCarInfo().getCarId(),
				order.getGetDate(),
				order.getReDate(),
				order.getGetAddress(),
				order.getReAddress(),
				order.getFee(),
				order.getOrderState()
				);
	}

	@Override
	public Order findOrderWithOrderState(Order order) {
		String sql = "SELECT orderId, userid, carId, getDate, reDate, getAddress, reAddress, fee, orderState FROM `Order` where userid = ? and carId = ? and orderState = ? ";
		
		ResultSet rs = this.dataQuery(sql, order.getNormalUser().getUserId(), order.getCarInfo().getCarId(), order.getOrderState());
		
		Order tmpOrder = null;
		CarInfo carInfo = null;
		NormalUser normalUser = null;
		
		try {
			if (rs.next()) {
				carInfo = new CarInfo();
				tmpOrder = new Order();
				normalUser = new NormalUser();
				
				carInfo.setCarId(rs.getInt("carId"));
				tmpOrder.setCarInfo(carInfo);
				
				normalUser.setUserId(rs.getInt("userid"));
				tmpOrder.setNormalUser(normalUser);
				
				tmpOrder.setOrderId(rs.getLong("orderId"));
				tmpOrder.setGetDate(rs.getDate("getDate"));
				tmpOrder.setReDate(rs.getDate("reDate"));
				tmpOrder.setGetAddress(rs.getString("getAddress"));
				tmpOrder.setReAddress(rs.getString("reAddress"));
				tmpOrder.setFee(rs.getBigDecimal("fee"));
				tmpOrder.setOrderState(rs.getInt("orderState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tmpOrder;
	}
	
	

	@Override
	public Order findOrderbyCarId(Integer carId) {
		String sql = "SELECT orderId, userid, carId, getDate, reDate, getAddress, reAddress, fee, orderState FROM `Order` where carId = ?";
		ResultSet rs = this.dataQuery(sql, carId);
		
		Order tmpOrder = null;
		CarInfo carInfo = null;
		NormalUser normalUser = null;
		
		try {
			if (rs.next()) {
				carInfo = new CarInfo();
				tmpOrder = new Order();
				normalUser = new NormalUser();
				
				carInfo.setCarId(rs.getInt("carId"));
				tmpOrder.setCarInfo(carInfo);
				
				normalUser.setUserId(rs.getInt("userid"));
				tmpOrder.setNormalUser(normalUser);
				
				tmpOrder.setOrderId(rs.getLong("orderId"));
				tmpOrder.setGetDate(rs.getDate("getDate"));
				tmpOrder.setReDate(rs.getDate("reDate"));
				tmpOrder.setGetAddress(rs.getString("getAddress"));
				tmpOrder.setReAddress(rs.getString("reAddress"));
				tmpOrder.setFee(rs.getBigDecimal("fee"));
				tmpOrder.setOrderState(rs.getInt("orderState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tmpOrder;
	}

	@Override
	public Order findOrderByOrderIdAndUserId(Long orderId, Integer userId) {
		String sql = "SELECT orderId, userid, carId, getDate, reDate, getAddress, reAddress, fee, orderState FROM `Order` where orderId = ? and userid = ? ";
		ResultSet rs = this.dataQuery(sql, orderId, userId);
		
		Order tmpOrder = null;
		CarInfo carInfo = null;
		NormalUser normalUser = null;
		
		try {
			if (rs.next()) {
				carInfo = new CarInfo();
				tmpOrder = new Order();
				normalUser = new NormalUser();
				
				carInfo.setCarId(rs.getInt("carId"));
				tmpOrder.setCarInfo(carInfo);
				
				normalUser.setUserId(rs.getInt("userid"));
				tmpOrder.setNormalUser(normalUser);
				
				tmpOrder.setOrderId(rs.getLong("orderId"));
				tmpOrder.setGetDate(rs.getDate("getDate"));
				tmpOrder.setReDate(rs.getDate("reDate"));
				tmpOrder.setGetAddress(rs.getString("getAddress"));
				tmpOrder.setReAddress(rs.getString("reAddress"));
				tmpOrder.setFee(rs.getBigDecimal("fee"));
				tmpOrder.setOrderState(rs.getInt("orderState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tmpOrder;
	}



	@Override
	public int getOrderInfoCountByCondition(List<String> userId, List<String> orderState, List<String> brandId) {
		
		int count = 0;
		
		StringBuffer sqlB = new StringBuffer("SELECT count(1) as count");
		sqlB.append(" FROM `Order` as o, CarInfo as c, Brand as b, CarType as i where o.carId = c.carId and i.cartypeId = c.cartypeId and b.brandId = i.brandId and 1=1");
		HashMap<String, List<String>> condetionMap = new HashMap<>();
		
		if (userId != null && !userId.isEmpty()) {
			condetionMap.put("userid", userId);
		}
		
		if (orderState != null && !orderState.isEmpty()) {
			condetionMap.put("orderState", orderState);
		}
		
		if (brandId != null && !brandId.isEmpty()) {
			condetionMap.put("b.brandId", brandId);
		}
		
		ResultSet rs = this.dataQueryByCondition(sqlB.toString(), condetionMap, null, null, null);
		try {
			if (rs.next()){
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		
		return count;
	}

	@Override
	public int cancelOrderByOrderId(Long orderId, Integer userId, Integer carId) {
		String sql = "UPDATE RentCar.`Order` SET orderState= ? WHERE orderId= ? and userId = ? and carId = ? ";
		return this.dataUpdate(sql, 1, orderId, userId, carId);
	}

	@Override
	public int updateOrderByOrder(Order order) {
		String sql = "UPDATE `Order` SET getDate = ? , reDate = ?, getAddress = ?, reAddress = ?, fee = ? WHERE orderId= ? and userid = ?";
		return this.dataUpdate(sql,
				order.getGetDate(),
				order.getReDate(),
				order.getGetAddress(),
				order.getReAddress(),
				order.getFee(),
				order.getOrderId(),
				order.getNormalUser().getUserId()
				);
	}

	@Override
	public int getOrderCountByCondition(List<String> userName, List<String> orderState, List<String> brandId,
			List<String> orderId) {
		int count = 0;
		
		StringBuffer sqlB = new StringBuffer("SELECT count(1) as count");
		sqlB.append(" FROM `Order` as o, CarInfo as c, Brand as b, CarType as i, users as u where u.userId = o.userId and o.carId = c.carId and i.cartypeId = c.cartypeId and b.brandId = i.brandId and 1=1");
		HashMap<String, List<String>> condetionMap = new HashMap<>();
		
		if (userName != null && !userName.isEmpty()) {
			condetionMap.put("userName", userName);
		}
		
		if (orderState != null && !orderState.isEmpty()) {
			condetionMap.put("orderState", orderState);
		}
		
		if (brandId != null && !brandId.isEmpty()) {
			condetionMap.put("b.brandId", brandId);
		}
		
		if (orderId != null && !orderId.isEmpty()) {
			condetionMap.put("orderId", orderId);
		}
		
		ResultSet rs = this.dataQueryByCondition(sqlB.toString(), condetionMap, null, null, null);
		try {
			if (rs.next()){
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		
		return count;
	}

	@Override
	public List<Order> findByCondsion(List<String> userName, List<String> orderState, List<String> brandId,
			List<String> orderId, Page<Order> page) {
		List<Order> list = new ArrayList<Order>();
		
		StringBuffer sqlB = new StringBuffer("SELECT userName, u.userid as userid, orderId, c.carId as carId, brandName, b.brandId as brandId, c.cartypeId as cartypeId, i.cartypeName as cartypeName, carJibie, carJiegou, carPailiang, getDate, getAddress, reAddress, reDate, carBox, carPeople, fee, orderState");
		sqlB.append(" FROM `Order` as o, CarInfo as c, Brand as b, CarType as i, Users as u where u.userid = o.userid and o.carId = c.carId and i.cartypeId = c.cartypeId and b.brandId = i.brandId and 1=1");
		HashMap<String, List<String>> condetionMap = new HashMap<>();
		
		if (userName != null && !userName.isEmpty()) {
			condetionMap.put("userName", userName);
		}
		
		if (orderState != null && !orderState.isEmpty()) {
			condetionMap.put("orderState", orderState);
		}
		
		if (brandId != null && !brandId.isEmpty()) {
			condetionMap.put("b.brandId", brandId);
		}
		
		if (orderId != null && !orderId.isEmpty()) {
			condetionMap.put("orderId", orderId);
		}
		
		List<String> orderBy = new ArrayList<>();
		orderBy.add("orderId DESC");
		
		ResultSet rs = this.dataQueryByCondition(sqlB.toString(), condetionMap, null, page, orderBy);
		try {
			Order order = null;
			CarInfo carInfo = null;
			NormalUser normalUser = null;
			CarType carType = null;
			Brand brand = null;
			while (rs.next()){
				order = new Order();
				order.setOrderId(rs.getLong("orderId"));
				carInfo = new CarInfo();
				carInfo.setCarId(rs.getInt("carId"));
				carInfo.setCarBox(rs.getString("carBox"));
				carInfo.setCarJibie(rs.getString("carJibie"));
				carInfo.setCarJiegou(rs.getString("carJiegou"));
				carInfo.setCarPailiang(rs.getString("carPailiang"));
				carInfo.setCarPeople(rs.getInt("carPeople"));
				order.setCarInfo(carInfo);
				order.setGetDate(rs.getDate("getDate"));
				order.setReDate(rs.getDate("reDate"));
				order.setGetAddress(rs.getString("getAddress"));
				order.setReAddress(rs.getString("reAddress"));
				order.setFee(rs.getBigDecimal("fee"));
				order.setOrderState(rs.getInt("orderState"));
				normalUser = new NormalUser();
				normalUser.setUserId(rs.getInt("userid"));
				normalUser.setUserName(rs.getString("userName"));
				order.setNormalUser(normalUser);
				carType = new CarType();
				carType.setCartypeId(rs.getInt("cartypeId"));
				carType.setCartypeName(rs.getString("cartypeName"));
				brand = new Brand();
				brand.setBrandName(rs.getString("brandName"));
				brand.setBrandId(rs.getInt("brandId"));
				carType.setBrand(brand);
				order.setCarType(carType);
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public int closeOrderByOrderId(Long orderId, Integer userId, Integer carId) {
		String sql = "UPDATE RentCar.`Order` SET orderState= ? WHERE orderId= ? and userId = ? and carId = ? ";
		return this.dataUpdate(sql, 2, orderId, userId, carId);
	}

}
