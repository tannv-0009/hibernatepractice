package com.example.entity;

public class Address {
	private int id;
	private String addressName;
	private int UserId;
	
	  public Address() {
	   }
	   
	  
	  public Address(String addressName) {
	      this.addressName = addressName;
	   }
	   
	 
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}

}
