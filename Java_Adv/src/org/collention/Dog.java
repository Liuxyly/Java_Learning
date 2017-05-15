package org.collention;

public class Dog {
	private String name;
	private String st;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the st
	 */
	public String getSt() {
		return st;
	}
	/**
	 * @param st the st to set
	 */
	public void setSt(String st) {
		this.st = st;
	}
	
	public Dog(){}
	
	public Dog(String name, String st){
		this.name = name;
		this.st = st;
	}
	
}
