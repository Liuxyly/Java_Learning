package org.liuxy.rentcar.entity;

public class NormalUser implements User {
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userPhone;
	private String userName;
	private String userPass;
	
	public NormalUser(){}
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}


	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public NormalUser(Integer userId, String userName, String userPhone) {
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	public NormalUser(String userName, String userPass) {
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public NormalUser(String userPhone, String userName, String userPass) {
		super();
		this.userPhone = userPhone;
		this.userName = userName;
		this.userPass = userPass;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the userPass
	 */
	public String getUserPass() {
		return userPass;
	}


	/**
	 * @param userPass the userPass to set
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
}
