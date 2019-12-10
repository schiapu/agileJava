import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transaction } from '../Model/Transaction';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  transaction:Transaction[];

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/transaction';

  getTransactions(){
    return this.http.get<Transaction[]>(this.Url);
  }

  creditTransaction(transaction:Transaction){
    return this.http.post<Transaction>(this.Url,transaction);
  }
}
