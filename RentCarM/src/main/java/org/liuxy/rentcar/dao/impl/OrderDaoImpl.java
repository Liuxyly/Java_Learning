package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.liuxy.rentcar.dao.OrderDao;
import org.liuxy.rentcar.entity.CarInfo;
import org.liuxy.rentcar.entity.CarType;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	public OrderDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> findAll() {
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT orderId, carId, getDate, reDate, getAddress, reAddress, fee, orderState, userid, c.cartypeId as typeid, cartypeName "
					+" FROM RentCar.`Order` as o, `CarType` as c WHERE c.cartypeId = o.cartypeId";
		ResultSet rs = this.dataQuery(sql);
		
		try {
			// 必须要用next()类似迭代器
			Order order = null;
			CarInfo carInfo = null;
			NormalUser normalUser = null;
			CarType carType = null;
			while (rs.next()){
				order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				carInfo = new CarInfo();
				carInfo.setCarId(rs.getInt("carId"));
				order.setCarInfo(carInfo);
				order.setGetDate(rs.getDate("getDate"));
				order.setReDate(rs.getDate("reDate"));
				order.setGetAddress(rs.getString("getAddress"));
				order.setReAddress(rs.getString("reAddress"));
				order.setFee(rs.getBigDecimal("fee"));
				order.setOrderState(rs.getInt("orderState"));
				normalUser = new NormalUser();
				normalUser.setUserId(rs.getInt("userid"));
				order.setNormalUser(normalUser);
				carType = new CarType();
				carType.setCartypeId(rs.getInt("typeid"));
				carType.setCartypeName(rs.getString("cartypeName"));
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
	public int updateOrderState(Integer orderState, Integer orderId) {
		String sql = "UPDATE `Order` SET orderState = ? WHERE orderId = ?;";
		return this.dataUpdate(sql, orderState, orderId);
	}

}
