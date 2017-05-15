package org.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserDaoInvocationHandler implements InvocationHandler {
	//需要代理的对象
	private Object proxyObj;
	
	public void setProxyObj(Object proxyObj) {
		this.proxyObj = proxyObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		UserTx tx = new UserTx();
		
		tx.before();
		Object resultObj = method.invoke(proxyObj, args);
		tx.after();
		
		return resultObj;
	}

}
