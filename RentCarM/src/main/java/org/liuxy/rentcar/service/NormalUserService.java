package org.liuxy.rentcar.service;

import org.liuxy.rentcar.entity.User;

public interface NormalUserService extends UserService {
	User verifyUser(String userName);
}
