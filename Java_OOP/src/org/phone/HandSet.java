package org.phone;

public abstract class HandSet {
	private String brand;
	private String type;
	
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public HandSet(){
		System.out.println("HandSet");
	}
	
	public HandSet(String brand, String type){
		this.setBrand(brand);
		this.setType(type);
	}
	
	public abstract void sendInfo();
	public abstract void call();
	public abstract void info();

}
