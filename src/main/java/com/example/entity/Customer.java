package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name ="customer")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "cus_name")
	private String cusName;

	@Column(name = "cus_email")
	private String cusEmail;

	@Column(name = "cus_address")
	private String cusAddress;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private  Transaction transaction;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
}
