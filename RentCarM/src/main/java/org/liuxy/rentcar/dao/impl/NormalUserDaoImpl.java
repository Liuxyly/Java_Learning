package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.liuxy.rentcar.dao.NormalUserDao;
import org.liuxy.rentcar.dao.UserDao;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.User;

public class NormalUserDaoImpl extends BaseDao implements NormalUserDao {

	@Override
	public User getUserByUser(User user) {
		
		NormalUser normalUser = null;
		
		if (user instanceof NormalUser) {
		
			String sql = "select userid, userName, userPhone, userPwd from users where userName = ? and userPwd = ?";
			ResultSet rs = this.dataQuery(sql, ((NormalUser) user).getUserName(), ((NormalUser) user).getUserPass());
			
			try {
				// 必须要用next()类似迭代器
				while (rs.next()){
					if (rs.getString("userName").equals(((NormalUser) user).getUserName())
							&& rs.getString("userPwd").equals(((NormalUser) user).getUserPass())) {
						normalUser = new NormalUser(rs.getInt("userid"), rs.getString("userName"), rs.getString("userPhone"));
					}
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

	@Override
	public User getUser(String userName) {
		String sql = "select userName from users where userName = ?";
		ResultSet rs = this.dataQuery(sql, userName);
		User user = null;
		try {
			while (rs.next()) {
				user = new NormalUser();
				
				((NormalUser)user).setUserName(rs.getString("userName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return user;
	}

}
