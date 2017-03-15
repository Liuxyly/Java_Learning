package org.Liuxy;

public class Student {
	String studentName;
	int    age;
	String classNo;
	String hobby;
	
	public void info() {
		System.out.println(studentName 	+ "\n"
							+ "年龄：" 	+ age + "\n"
							+ "就读于：" 	+ classNo + "\n"
							+ "爱好：" 	+ hobby);
	}

}
