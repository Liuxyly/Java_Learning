package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.liuxy.rentcar.dao.UserDao;
import org.liuxy.rentcar.entity.AdminUser;
import org.liuxy.rentcar.entity.User;

public class AdminDaoImpl extends BaseDao implements UserDao {
	
	private AdminUser adminUser;
	
	public AdminDaoImpl() {
		
	}

	@Override
	public User getUserByUser(User user) {
		
		if (user instanceof AdminUser) {
			this.adminUser = (AdminUser)user;
		
			String sql = "SELECT adminId, adminName FROM AdminUsers WHERE adminName = ? AND adminPwd = ?";
			ResultSet rs = this.dataQuery(sql, this.adminUser.getAdminName(), this.adminUser.getAdminPwd());
			
			try {
				// 必须要用next()类似迭代器
				while (rs.next()){
					this.adminUser = new AdminUser(rs.getInt("adminId"), rs.getString("adminName"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.closeAll();
			}
		}
		
		return this.adminUser;
	}

	@Override
	public int addUserByUser(User user) {
		
		String sql = "insert into AdminUsers(adminName, adminPwd) values(?, ?)";
		if (user instanceof AdminUser) {
			this.adminUser = (AdminUser)user;
			return this.dataUpdate(sql, this.adminUser.getAdminName(), this.adminUser.getAdminPwd());
		} else {
			return 0;
		}
	}

	@Override
	public int delUser(User user) {
		
		String sql = "DELETE FROM AdminUsers WHERE adminId = ?";
		if (user instanceof AdminUser) {
			this.adminUser = (AdminUser)user;
			return this.dataUpdate(sql, this.adminUser.getAdminId());
		} else {
			return 0;
		}
	}

	@Override
	public int updateUser(User user) {
		
		String sql = "UPDATE AdminUsers SET adminName = ?, adminPwd = ? WHERE adminId = ?;";
		if (user instanceof AdminUser) {
			this.adminUser = (AdminUser)user;
			return this.dataUpdate(sql, this.adminUser.getAdminName(), this.adminUser.getAdminPwd(), this.adminUser.getAdminId());
		} else {
			return 0;
		}
	}

}
