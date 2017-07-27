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
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
