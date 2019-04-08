package com.examples.stream;

public class Employee {
	
	private String name;
	private String city;
	private Integer numOfSale;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Employee(String name, String city, Integer numOfSale) {
		super();
		this.name = name;
		this.city = city;
		this.numOfSale = numOfSale;
	}





	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getNumOfSale() {
		return numOfSale;
	}
	public void setNumOfSale(Integer numOfSale) {
		this.numOfSale = numOfSale;
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", numOfSale=" + numOfSale + "]";
	}
	

}
