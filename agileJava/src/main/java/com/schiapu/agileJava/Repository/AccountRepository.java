package com.schiapu.agileJava.Repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.schiapu.agileJava.Model.Account;
import com.schiapu.agileJava.Model.Transaction;

@Repository
public class AccountRepository {
	private Account mainAccount;

	@Autowired
	public AccountRepository(Account account) {
		this.mainAccount = account;
	}

	public ArrayList<Transaction> getTransactionList() {		
		return this.mainAccount.getTransactionList();
	}
	
	public HttpStatus addTransaction(Transaction transaction) {
		return this.mainAccount.addTransaction(transaction);
	}

}
