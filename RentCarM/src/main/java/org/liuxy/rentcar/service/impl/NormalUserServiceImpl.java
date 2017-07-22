package org.liuxy.rentcar.service.impl;

import org.liuxy.rentcar.dao.UserDao;
import org.liuxy.rentcar.dao.impl.NormalUserDaoImpl;
import org.liuxy.rentcar.entity.NormalUser;
import org.liuxy.rentcar.entity.User;
import org.liuxy.rentcar.service.NormalUserService;

public class NormalUserServiceImpl implements NormalUserService {

	private UserDao userDao = new NormalUserDaoImpl();
	
	public NormalUserServiceImpl() {
		
	}

	@Override
	public NormalUser login(User user) {
		return (NormalUser)userDao.getUserByUser(user);
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
