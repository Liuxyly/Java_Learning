package org.liuxy.rentcar.service.impl;

import org.liuxy.rentcar.dao.UserDao;
import org.liuxy.rentcar.dao.impl.AdminDaoImpl;
import org.liuxy.rentcar.entity.User;
import org.liuxy.rentcar.service.AdminUserService;

public class AdminUserServiceImpl implements AdminUserService {

	private UserDao userDao = new AdminDaoImpl();
	
	public AdminUserServiceImpl() {
		
	}

	@Override
	public User login(User user) {
		return userDao.getUserByUser(user);
	}

	@Override
	public int register(User user) {
		return userDao.addUserByUser(user);
	}

	@Override
	public int delUser(User user) {
		return userDao.delUser(user);
	}

	@Override
	public int alterUser(User user) {
		return userDao.updateUser(user);
	}

}
