package org.liuxy.pojo;

import java.io.Serializable;

public class CarType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CarType() {
		// TODO Auto-generated constructor stub
	}
	
	private Long cartypeId;
	private Long brandId;
	private String cartypeName;
	/**
	 * @return the cartypeId
	 */
	public Long getCartypeId() {
		return cartypeId;
	}
	/**
	 * @param cartypeId the cartypeId to set
	 */
	public void setCartypeId(Long cartypeId) {
		this.cartypeId = cartypeId;
	}
	/**
	 * @return the brandId
	 */
	public Long getBrandId() {
		return brandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarType [cartypeId=" + cartypeId + ", brandId=" + brandId + ", cartypeName=" + cartypeName + "]";
	}
	
}
