package org.liuxy.rentcar.entity;

public class CarType {
	
	private Integer cartypeId;
	private String cartypeName;
	private Brand brand;
	
	public CarType() {
		
	}
	
	public CarType(Integer cartypeId, String cartypeName) {
		this.cartypeId = cartypeId;
		this.cartypeName = cartypeName;
	}

	/**
	 * @return the cartypeId
	 */
	public Integer getCartypeId() {
		return cartypeId;
	}

	/**
	 * @param cartypeId the cartypeId to set
	 */
	public void setCartypeId(Integer cartypeId) {
		this.cartypeId = cartypeId;
	}

	/**
	 * @return the cartypeName
	 */
	public String getCartypeName() {
		return cartypeName;
	}

	/**
	 * @param cartypeName the cartypeName to set
	 */
	public void setCartypeName(String cartypeName) {
		this.cartypeName = cartypeName;
	}

	/**
	 * @return the brond
	 */
	public Brand getBrond() {
		return brand;
	}

	/**
	 * @param brand the brond to set
	 */
	public void setBrond(Brand brand) {
		this.brand = brand;
	}
	
	
	
}
