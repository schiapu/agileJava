package com.schiapu.agileJava.Model;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class Account {
        
    @SuppressWarnings("unused")
	private UUID id;
    private Double totalValue;
    private ArrayList<Transaction> transactionList;
    private ReadWriteLock saveLock;

    public Account() {
        this.id = UUID.randomUUID();
        this.totalValue = 0d;
        this.transactionList = new ArrayList<Transaction>();
        this.saveLock = new ReentrantReadWriteLock();
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public HttpStatus addTransaction(Transaction transaction) {
        saveLock.writeLock().lock();
        try{
            if(validateTransactionTotalValue(transaction)){
                this.transactionList.add(transaction);
                return HttpStatus.OK;
            }
            else
            {
                return HttpStatus.CONFLICT;
            }   
        }
        finally{
            saveLock.writeLock().unlock();
        }

    }

    private Boolean validateTransactionTotalValue(Transaction transaction){
        if (transaction.getType() == TransactionType.CREDIT) {
            totalValue += transaction.getAmount();
        }
        else {
                if (totalValue - transaction.getAmount() < 0) {
                        return false;
                }
                else {
                        totalValue -= transaction.getAmount();
                }
        }
        return true;
    }
}
