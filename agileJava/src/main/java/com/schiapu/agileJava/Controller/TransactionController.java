package com.schiapu.agileJava.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.schiapu.agileJava.Model.Transaction;
import com.schiapu.agileJava.Service.AccountService;

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	private AccountService accountService;
	@Autowired
    public TransactionController(AccountService accountService) {
        this.accountService = accountService;
    }
	
	@GetMapping
	public List<Transaction> list(){
		return accountService.getTransactionList();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> add(@RequestBody Transaction t){
		return accountService.addTransaction(t);
	}
	
}
