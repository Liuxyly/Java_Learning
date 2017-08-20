package org.liuxy.pojo;

import java.util.Date;

public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	private Long studentNo;
	private String loginPwd; 
	private String studentName;
	private Integer sex;
	private Long gradeID;
	private String phone;
	private String address;
	private Date bornDate;
	private String email;
	private String identityCard;
	/**
	 * @return the studentNo
	 */
	public Long getStudentNo() {
		return studentNo;
	}
	/**
	 * @param studentNo the studentNo to set
	 */
	public void setStudentNo(Long studentNo) {
		this.studentNo = studentNo;
	}
	/**
	 * @return the loginPwd
	 */
	public String getLoginPwd() {
		return loginPwd;
	}
	/**
	 * @param loginPwd the loginPwd to set
	 */
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
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
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * @return the gradeID
	 */
	public Long getGradeID() {
		return gradeID;
	}
	/**
	 * @param gradeID the gradeID to set
	 */
	public void setGradeID(Long gradeID) {
		this.gradeID = gradeID;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the bornDate
	 */
	public Date getBornDate() {
		return bornDate;
	}
	/**
	 * @param bornDate the bornDate to set
	 */
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the identityCard
	 */
	public String getIdentityCard() {
		return identityCard;
	}
	/**
	 * @param identityCard the identityCard to set
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", loginPwd=" + loginPwd + ", studentName=" + studentName + ", sex="
				+ sex + ", gradeID=" + gradeID + ", phone=" + phone + ", address=" + address + ", bornDate=" + bornDate
				+ ", email=" + email + ", identityCard=" + identityCard + "]";
	}
}
