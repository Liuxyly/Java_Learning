package org.liuxy.rentcar.service;

import org.liuxy.rentcar.entity.User;

public interface UserService {
	User login(User user);
	int register(User user);
	int delUser(User user);
	int alterUser(User user);
}
