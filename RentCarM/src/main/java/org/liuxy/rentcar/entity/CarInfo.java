package org.liuxy.rentcar.entity;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;

public class CarInfo {
	
	private Integer carId;
	private CarType carType;
	private String carJibie;
	private String carJiegou;
	private String carPailiang;
	private String carBox;
	private Integer carPeople;
	private BigDecimal price;
	private BigDecimal discount;
	private InputStream imageData;
	private Integer carState;
	
	public CarInfo() {
		
	}
	
	/**
	 * @return the imageData
	 */
	public InputStream getImageData() {
		return imageData;
	}



	/**
	 * @param imageData the imageData to set
	 */
	public void setImageData(InputStream imageData) {
		this.imageData = imageData;
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
	 * @return the carId
	 */
	public Integer getCarId() {
		return carId;
	}

	/**
	 * @param carId the carId to set
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	/**
	 * @return the carJibie
	 */
	public String getCarJibie() {
		return carJibie;
	}

	/**
	 * @param carJibie the carJibie to set
	 */
	public void setCarJibie(String carJibie) {
		this.carJibie = carJibie;
	}

	/**
	 * @return the carJiegou
	 */
	public String getCarJiegou() {
		return carJiegou;
	}

	/**
	 * @param carJiegou the carJiegou to set
	 */
	public void setCarJiegou(String carJiegou) {
		this.carJiegou = carJiegou;
	}

	/**
	 * @return the carPailiang
	 */
	public String getCarPailiang() {
		return carPailiang;
	}

	/**
	 * @param carPailiang the carPailiang to set
	 */
	public void setCarPailiang(String carPailiang) {
		this.carPailiang = carPailiang;
	}

	/**
	 * @return the carBox
	 */
	public String getCarBox() {
		return carBox;
	}

	/**
	 * @param carBox the carBox to set
	 */
	public void setCarBox(String carBox) {
		this.carBox = carBox;
	}

	/**
	 * @return the carPeople
	 */
	public Integer getCarPeople() {
		return carPeople;
	}

	/**
	 * @param carPeople the carPeople to set
	 */
	public void setCarPeople(Integer carPeople) {
		this.carPeople = carPeople;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * @return the carState
	 */
	public Integer getCarState() {
		return carState;
	}

	/**
	 * @param carState the carState to set
	 */
	public void setCarState(Integer carState) {
		this.carState = carState;
	}
	
	
	
}
