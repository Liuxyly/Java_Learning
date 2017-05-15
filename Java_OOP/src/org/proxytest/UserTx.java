package org.proxytest;
/**
 * 定义需要向UserDao添加功能的类
 * 
 * */
public class UserTx {
	
	public void before() {
		System.out.println("before save ...");
	}
	
	public void after() {
		System.out.println("after save ...");
	}
}
