package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.liuxy.rentcar.dao.UserDao;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.User;

public class NormalUserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User getUserByUser(User user) {
		NormalUser normalUser = null;
		
		if (user instanceof NormalUser) {
			normalUser = (NormalUser)user;
		
			String sql = "select userid, userName, userPhone from users where userName = ? and userPwd = ?";
			ResultSet rs = this.dataQuery(sql, normalUser.getUserName(), normalUser.getUserPass());
			
			try {
				// 必须要用next()类似迭代器
				while (rs.next()){
					normalUser = new NormalUser(rs.getInt("userid"), rs.getString("userName"), rs.getString("userPhone"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.closeAll();
			}
		}
		
		return normalUser;
	}

	@Override
	public int addUserByUser(User user) {
		
		NormalUser normalUser = null;
		String sql = "insert into users(userName, userPwd, userPhone) values(?, ?, ?);";
		if (user instanceof NormalUser) {
			normalUser = (NormalUser)user;
			return this.dataUpdate(sql, normalUser.getUserName(), normalUser.getUserPass(), normalUser.getUserPhone());
		} else {
			return 0;
		}
	}

	@Override
	public int delUser(User user) {
		
		NormalUser normalUser = null;
		String sql = "DELETE FROM users WHERE userid = ?";
		if (user instanceof NormalUser) {
			normalUser = (NormalUser)user;
			return this.dataUpdate(sql, normalUser.getUserId());
		} else {
			return 0;
		}
	}

	@Override
	public int updateUser(User user) {
		
		NormalUser normalUser = null;
		String sql = "UPDATE Users SET userName = ?, userPwd = ?, userPhone = ? WHERE userid = ?";
		if (user instanceof NormalUser) {
			normalUser = (NormalUser)user;
			return this.dataUpdate(sql, normalUser.getUserName(), normalUser.getUserPass(), normalUser.getUserPhone(), normalUser.getUserId());
		} else {
			return 0;
		}
	}

}
