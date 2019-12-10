package com.schiapu.agileJava.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.schiapu.agileJava.Model.Transaction;
import com.schiapu.agileJava.Repository.AccountRepository;

@Service
public class AccountService {

	private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public ArrayList<Transaction> getTransactionList() {
		return this.accountRepository.getTransactionList();
	}
    
    public ResponseEntity<String> addTransaction(Transaction transaction) {
    	HttpStatus result = accountRepository.addTransaction(transaction);
    	if (result == HttpStatus.OK) {
			return new ResponseEntity<>("Transaction Processed Correctly", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Transaction Failed", result);
		}
	}
}
