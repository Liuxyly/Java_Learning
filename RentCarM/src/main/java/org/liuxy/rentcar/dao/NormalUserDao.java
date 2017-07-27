package org.liuxy.rentcar.dao;

import org.liuxy.rentcar.entity.User;

public interface NormalUserDao extends UserDao {
	User getUser(String userName);
}
