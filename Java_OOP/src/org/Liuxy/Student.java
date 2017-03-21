package org.Liuxy;

public class Student {
	private String studentName;
	private int    age;
	private String classNo;
	private String hobby;
	
	public Student(){
	}
	
	
	
	public Student(int a, String b){}
	
	public Student(String a, int b){}
	
	public void info() {
		System.out.println(studentName 	+ "\n"
							+ "年龄：" 	+ age + "\n"
							+ "就读于：" 	+ classNo + "\n"
							+ "爱好：" 	+ hobby);
	}
	
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}



	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}



	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}



	/**
	 * @return the classNo
	 */
	public String getClassNo() {
		return classNo;
	}



	/**
	 * @param classNo the classNo to set
	 */
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}



	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}



	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
