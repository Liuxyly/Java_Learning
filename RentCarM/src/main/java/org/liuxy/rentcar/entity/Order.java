package org.liuxy.rentcar.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	
	private Integer orderId;
	private CarInfo carInfo;
	private Date getDate;
	private Date reDate;
	private String getAddress;
	private String reAddress;
	private CarType carType;
	private BigDecimal fee;
	private Integer orderState;
	private NormalUser normalUser;
	
	public Order() {
		
	}

	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the carInfo
	 */
	public CarInfo getCarInfo() {
		return carInfo;
	}

	/**
	 * @param carInfo the carInfo to set
	 */
	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	/**
	 * @return the getDate
	 */
	public Date getGetDate() {
		return getDate;
	}

	/**
	 * @param getDate the getDate to set
	 */
	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	/**
	 * @return the reDate
	 */
	public Date getReDate() {
		return reDate;
	}

	/**
	 * @param reDate the reDate to set
	 */
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}

	/**
	 * @return the getAddress
	 */
	public String getGetAddress() {
		return getAddress;
	}

	/**
	 * @param getAddress the getAddress to set
	 */
	public void setGetAddress(String getAddress) {
		this.getAddress = getAddress;
	}

	/**
	 * @return the reAddress
	 */
	public String getReAddress() {
		return reAddress;
	}

	/**
	 * @param reAddress the reAddress to set
	 */
	public void setReAddress(String reAddress) {
		this.reAddress = reAddress;
	}

	/**
	 * @return the carType
	 */
	public CarType getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	/**
	 * @return the fee
	 */
	public BigDecimal getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	/**
	 * @return the orderState
	 */
	public Integer getOrderState() {
		return orderState;
	}

	/**
	 * @param orderState the orderState to set
	 */
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	/**
	 * @return the normalUser
	 */
	public NormalUser getNormalUser() {
		return normalUser;
	}

	/**
	 * @param normalUser the normalUser to set
	 */
	public void setNormalUser(NormalUser normalUser) {
		this.normalUser = normalUser;
	}
	
	
	
}
