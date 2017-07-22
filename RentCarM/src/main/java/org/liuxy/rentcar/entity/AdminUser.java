package org.liuxy.rentcar.entity;

public class AdminUser implements User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer adminId;
	private String adminName;
	private String adminPwd;
	
	/**
	 * @return the adminId
	 */
	public Integer getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return the adminPwd
	 */
	public String getAdminPwd() {
		return adminPwd;
	}

	/**
	 * @param adminPwd the adminPwd to set
	 */
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public AdminUser(String adminName, String adminPwd) {
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}
	
	public AdminUser(Integer adminId, String adminName, String adminPwd) {
		this(adminId, adminName);
		this.adminPwd = adminPwd;
	}
	
	public AdminUser(Integer adminId, String adminName) {
		this.adminId = adminId;
		this.adminName = adminName;
	}

}
