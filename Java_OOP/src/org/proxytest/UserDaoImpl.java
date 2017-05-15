package org.proxytest;

public class UserDaoImpl implements UserDao {
	//我们现在要对UserDao接口添加功能
	@Override
	public void save() {
		System.out.println("I'm save uesr ...");
	}

}
