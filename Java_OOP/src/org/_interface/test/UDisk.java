package org._interface.test;

public class UDisk implements USB {

	@Override
	public void service() {
		System.out.println("传输数据");
	}
	
	public void test(){
		System.out.println("容量为32GB");
	}

}
