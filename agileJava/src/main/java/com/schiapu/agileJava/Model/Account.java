package com.schiapu.agileJava.Model;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class Account {
	private Double totalValue;
	private ArrayList<Transaction> transactionList;
	private Boolean lock;
	
	public Account() {
		this.totalValue = 0d;
		this.transactionList = new ArrayList<Transaction>();
		this.lock = false;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}
	
	public HttpStatus addTransaction(Transaction transaction) {
		if (lock) {
			return HttpStatus.LOCKED;
		}
		else {
			lock = true;
			if (transaction.getType() == TransactionType.CREDIT) {
				totalValue += transaction.getAmount();
			}
			else {
				if (totalValue - transaction.getAmount() < 0) {
					return HttpStatus.CONFLICT;
				}
				else {
					totalValue -= transaction.getAmount();
				}
			}

			this.transactionList.add(transaction);
			lock = false;
			return HttpStatus.OK;
		}
		
	}

	public Boolean getLock() {
		return lock;
	}

	public void setLock(Boolean lock) {
		this.lock = lock;
	}

}
