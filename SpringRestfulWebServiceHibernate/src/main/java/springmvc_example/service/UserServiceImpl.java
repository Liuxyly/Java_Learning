package springmvc_example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.UserDao;
import springmvc_example.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	UserDao userDao;
	
	/**
	 * @param userDao the userDao to set
	 */
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getListUser() {
		return userDao.getListUser();
	}

	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

}
