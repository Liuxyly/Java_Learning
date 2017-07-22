package org.liuxy.rentcar.dao;

import org.liuxy.rentcar.entity.User;

public interface UserDao {

	User getUserByUser(User user);
	int addUserByUser(User user);
	int delUser(User user);
	int updateUser(User user);

}
