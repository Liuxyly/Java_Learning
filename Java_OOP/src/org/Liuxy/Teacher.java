package org.Liuxy;

public class Teacher {
	String 	teachName;
	String 	specialized;
	String 	Teach;
	int		TeachAge;
	
	public void info() {
		System.out.println(teachName 		+ "\n"
							+ "专业方向：" 	+ specialized + "\n"
							+ "教授课程：" 	+ Teach + "\n"
							+ "教龄：" 		+ TeachAge);
	}

}
