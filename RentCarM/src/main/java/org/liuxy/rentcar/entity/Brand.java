package org.liuxy.rentcar.entity;

public class Brand {
	
	private Integer brandId;
	private String brandName;
	
	public Brand() {
		
	}
	
	public Brand(Integer brandId, String brandName) {
		this.brandId = brandId;
		this.brandName = brandName;
	}

	/**
	 * @return the brandId
	 */
	public Integer getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	

}
