package com.example.entity;

import com.example.utils.DateUtil;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name ="transaction")
public class Transaction implements Serializable {


	public Transaction( Customer customer)
	{
		this.customer=customer;
	}

	public Transaction()
	{
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}


	public int getTxnTotal() {
		return txnTotal;
	}

	public void setTxnTotal(int txnTotal) {
		this.txnTotal = txnTotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "txn_date")
	private Date txnDate;

	@Column(name = "txn_total")
	private int txnTotal;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="customer_id", referencedColumnName = "id")
	private Customer customer;

	@Override
	public String toString() {
		return  String.format("Id: %d, Customer: %s, Total: %s", id, customer.getCusName(),txnTotal);

	}
}
