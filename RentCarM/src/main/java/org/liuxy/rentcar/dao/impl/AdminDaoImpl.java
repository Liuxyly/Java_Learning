package org.liuxy.rentcar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.liuxy.rentcar.dao.UserDao;
import org.liuxy.rentcar.entity.AdminUser;
import org.liuxy.rentcar.entity.User;

public class AdminDaoImpl extends BaseDao implements UserDao {
	
	public AdminDaoImpl() {
		
	}

	@Override
	public User getUserByUser(User user) {
		
		AdminUser adminUser = null;
		
		if (user instanceof AdminUser) {
		
			String sql = "SELECT adminId, adminName, adminPwd FROM AdminUsers WHERE adminName = ? AND adminPwd = ?";
			ResultSet rs = this.dataQuery(sql, ((AdminUser) user).getAdminName(), ((AdminUser) user).getAdminPwd());
			
			try {
				// 必须要用next()类似迭代器
				while (rs.next()){
					if (rs.getString("adminName").equals(((AdminUser) user).getAdminName())
							&& rs.getString("adminPwd").equals(((AdminUser) user).getAdminPwd())) {
						adminUser = new AdminUser(rs.getInt("adminId"), rs.getString("adminName"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.closeAll();
			}
		}
		
		return adminUser;
	}

	@Override
	public int addUserByUser(User user) {
		
		String sql = "insert into AdminUsers(adminName, adminPwd) values(?, ?)";
		if (user instanceof AdminUser) {
			return this.dataUpdate(sql, ((AdminUser) user).getAdminName(), ((AdminUser) user).getAdminPwd());
		} else {
			return 0;
		}
	}

	@Override
	public int delUser(User user) {
		
		String sql = "DELETE FROM AdminUsers WHERE adminId = ?";
		if (user instanceof AdminUser) {
			return this.dataUpdate(sql, ((AdminUser) user).getAdminId());
		} else {
			return 0;
		}
	}

	@Override
	public int updateUser(User user) {
		
		String sql = "UPDATE AdminUsers SET adminName = ?, adminPwd = ? WHERE adminId = ?;";
		if (user instanceof AdminUser) {
			return this.dataUpdate(sql, ((AdminUser) user).getAdminName(), ((AdminUser) user).getAdminPwd(), ((AdminUser) user).getAdminId());
		} else {
			return 0;
		}
	}

}
