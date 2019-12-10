package com.schiapu.agileJava.Model;

import java.util.Date;
import java.util.UUID;

public class Transaction {
	private UUID id;
	private Double amount;
	private TransactionType type;
	private Date date;
	
	public Transaction(Double amount, TransactionType type) {
		this.id = UUID.randomUUID();
		this.amount = amount;
		this.date = new Date();
		this.type = type;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public UUID getId() {
		return id;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
