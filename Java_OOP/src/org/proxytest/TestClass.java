package org.proxytest;

import java.lang.reflect.Proxy;

public class TestClass {

	public static void main(String[] args) {
		UserDao target = new UserDaoImpl();
		
		UserDaoInvocationHandler handler = new UserDaoInvocationHandler();
		handler.setProxyObj(target);
		UserDao targeted = (UserDao) Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				handler);
		
		targeted.save();
	}

}
