package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.example.utils.DateUtil;


public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public User( String name, Date dateOfBirth, List<Address> address) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public User() {
	}
	private long id;
	private String name;
	private Date dateOfBirth;
	private List<Address>  address;
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return  String.format("Id: %d, Name: %s, DateOfBirth: %s", id, name,dateOfBirth!=null ?  DateUtil.dateFormat().format(dateOfBirth): "");

	}
}
